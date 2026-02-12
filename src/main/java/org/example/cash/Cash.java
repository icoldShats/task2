package org.example.cash;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cash {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface CacheResult {}

    private Map<String,Object> cache = new HashMap<>();

    @CacheResult
    public Integer sum(Integer a,Integer b){
        System.out.println("кэшируется");
        return a+b;
    }

    public Object call(String methosName,Object... arg) throws Exception{
        Class<?>[] argTypes= Arrays.stream(arg)
                .map(Object::getClass)
                .toArray(Class[]::new);
        Method method=this.getClass().getMethod(methosName,argTypes);

        if (method.isAnnotationPresent(CacheResult.class)){
            String key = Arrays.toString(arg);
            if (cache.containsKey(key)){
                System.out.println("Берем из кеша");
                return cache.get(key);
            }
            Object result =method.invoke(this,arg);
            cache.put(key,result);
            return result;
        }
        return method.invoke(this,arg);

    }

}
