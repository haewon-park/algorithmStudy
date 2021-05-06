package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11399 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] times = new int[n];
        int sum = 0, result = 0;

        for (int i=0; i<n; i++) {
            times[i] = scan.nextInt();
        }

        Arrays.sort(times);

        for (int i=0; i<n; i++) {
            sum += times[i];
            result += sum;
        }

        System.out.println(result);
        scan.close();
    }

}
