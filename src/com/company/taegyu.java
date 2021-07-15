package com.company;

public class taegyu {
    public static void main(String[] args) {
        double result1 = 10 * 10 * Ccalculator.pi;
        int result2 = Ccalculator.plus(10, 1);
        int result3 = Ccalculator.minus(10, 1);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static class Ccalculator{
        static double pi = 3.14159;

        static int plus(int x, int y){
            return x + y;
        }

        static int minus(int x, int y){
            return x - y;
        }
    }

}