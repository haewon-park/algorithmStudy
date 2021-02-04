package com.company;

import java.io.*;
import java.util.*;

public class boj_14888 {
    public static long max = Long.MIN_VALUE;
    public static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int subtract = Integer.parseInt(st.nextToken());
        int multiply = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        calc(A, plus, subtract, multiply, divide, 1, A[0]);
        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void calc(long[] A, int plus, int subtract, int multiply, int divide, int i, long result){
        if(plus == 0 && subtract == 0 && multiply == 0 && divide == 0){
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        if(plus != 0) {
            calc(A, plus - 1, subtract, multiply, divide, i + 1, result + A[i]);
        }

        if(subtract != 0) {
            calc(A, plus, subtract - 1, multiply, divide, i + 1, result - A[i]);
        }

        if(multiply != 0) {
            calc(A, plus, subtract, multiply - 1, divide, i + 1, result * A[i]);
        }

        if(divide != 0) {
            calc(A, plus, subtract, multiply, divide - 1, i + 1, result / A[i]);
        }
    }
}