package com.company;

// 참고: https://takeknowledge.tistory.com/92

import java.io.*;
import java.util.Arrays;

public class boj_6588 {
    static int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i < MAX; i++){
            if(isPrime[i]){
                for(int j = i + i; j <= MAX; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int n, a, b;
        while ((n = Integer.parseInt(br.readLine())) != 0){
            for(int i = 3; i < n; i++){
                if(isPrime[i]){
                    a = i;
                    if(isPrime[n - a]){
                        b = n - a;
                        bw.write(n + " = " + a + " + " + b + "\n");
                        bw.flush();
                        break;
                    }
                }
            }
        }

        br.close();
        bw.close();
    }
}
