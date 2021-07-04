package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];

        for(int i = 0; i < 3; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(((num[0] + num[1]) % num[2]) + "\n");
        bw.write((num[0] % num[2] + num[1] % num[2]) % num[2] + "\n");
        bw.write(((num[0] * num[1]) % num[2]) + "\n");
        bw.write((num[0] % num[2] * num[1] % num[2]) % num[2] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
