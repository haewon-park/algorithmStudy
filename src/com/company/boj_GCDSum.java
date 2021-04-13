package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_GCDSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] num = new long[n];
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;

            for (int x = 0; x < num.length; x++) {
                for (int y = x + 1; y < num.length; y++) {
                    answer += gcd(num[x], num[y]);
                }
            }

            bw.write(answer + "\n");

        }

        bw.flush();
        bw.close();
    }

    public static long gcd(long a, long b) {
        while(b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}