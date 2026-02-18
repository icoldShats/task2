package org.example.cash;

public class Main {
    public static void main(String[] args) throws Exception {

        Cash task = new Cash();

        System.out.println(task.call("sum", 2, 3));
        System.out.println(task.call("sum", 2, 3));
        System.out.println(task.call("sum", 5, 1));
        System.out.println(task.call("sum", 5, 1));
    }

}
