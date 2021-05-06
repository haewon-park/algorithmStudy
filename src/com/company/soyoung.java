package com.company;

import java.util.*;

public class soyoung {
    public static int Addition(int[] listOfValues, int listLength) {
        int total = 0;
        for (int i = 0; i < listLength; i++)
            total = total + listOfValues[i];
        return (total);//값 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //입력을 위한 변수 선언
        System.out.println("How many numbers will you enter?");//""속 문장 출력
        int number = sc.nextInt();  //number 입력 받기

        int[] theList = new int[number];
        int idx;
        int sum;
        int percent;

        System.out.println("Enter " + number + "integers, one per line:");//""속 문장 출력

        for (idx = 0; idx < number; idx++) {
            theList[idx] = sc.nextInt();
        }

        sum = Addition(theList, number);
        System.out.println("The sum is " + sum);//""속 문장 출력
        System.out.println("The numbers are:");//""속 문장 출력
        for (idx = 0; idx < number; idx++)
            System.out.println(theList[idx] + ", which is " + Math.floor(((double) theList[idx] / sum) * 100 + 0.5 * 10000)/10000.0 + "% of the sum.");//""속 문장 출력
    }
}

