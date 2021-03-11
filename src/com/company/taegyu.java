package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class taegyu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int total = 0;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < c; k++) {
                    String str = i + " " + j + " " + k;
                    bw.write(str + "\n");
                    total++;
                }
            }
        }

        bw.write(total + "\n");
        bw.close();
        br.close();
    }

}