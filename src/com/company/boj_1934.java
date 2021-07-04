package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1934 {
    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);
            int lcm = (a * b) / gcd;
            bw.write(lcm + "");
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
