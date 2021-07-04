package com.company;

import java.io.*;

public class boj_14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int current = 1;
        int copy = 1;
        int time = 0;
        int S = Integer.parseInt(br.readLine());

        while(current != S){
            current += copy;
            current--;

            copy = current;
            time++;
        }

        bw.write(time + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
