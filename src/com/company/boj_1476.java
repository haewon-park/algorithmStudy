package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year, e, s, m;
        year = e = s = m = 1;

        while (true){
            if(e == E && s == S && m == M){
                break;
            }

            e++;
            s++;
            m++;

            if(e == 16){
                e = 1;
            }

            if(s == 29){
                s = 1;
            }

            if(m == 20){
                m = 1;
            }

            year++;
        }

        bw.write(year + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
