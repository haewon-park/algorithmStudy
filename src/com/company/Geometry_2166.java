package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[] x = new long[num + 1];
        long[] y = new long[num + 1];

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[num] = x[0];
        y[num] = y[0];

        long result = 0;

        for(int i = 0; i < num; i++){
            result += (x[i] * y[i+1]) - (x[i+1] * y[i]);
        }

        String area = String.format("%.1f", Math.abs(result) / 2.0);
        bw.write(area);

        bw.flush();
        br.close();
        bw.close();
    }
}