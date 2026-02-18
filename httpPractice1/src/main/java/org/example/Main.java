package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int N=3;

        List<List<Integer>>parts=splitList(numbers,N);

        ExecutorService executor = Executors.newFixedThreadPool(N);
        List<Future<Integer>> futures= new ArrayList<>();

        for(List<Integer> part : parts){
            Callable<Integer> task=()->{
                int sum =0;
                for(int num :part){
                    sum+=num;
                }
                return sum;
            };
            futures.add(executor.submit(task));
        }

        int totalSum=0;
        for(Future<Integer> future :futures){
            totalSum +=future.get();
        }
        executor.shutdown();

        System.out.println("Total sum: " + totalSum);


    }
    public static List<List<Integer>> splitList(List<Integer> list,int N){
        List<List<Integer>> parts =new ArrayList<>();
        int size =list.size();
        int splitSize = (size + N -1)/N;

        for(int i=0;i<size;i+=splitSize){
            parts.add(list.subList(i,Math.min(size, i+splitSize)));
        }
        return parts;


    }
}
