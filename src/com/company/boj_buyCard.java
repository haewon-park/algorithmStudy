package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_buyCard {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] map = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=1; i<=n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = map[i];
        }

        dp[0] = map[0];
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=i/2; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + map[j]); //i-j개 구하는 최대 가격 + j개를 사기 위한 비용
//                System.out.println("dp[i]="+dp[i]+", dp[i - j] + price[j] = "+(dp[i - j]+map[j]));
//                System.out.println("i="+i+", i-j="+(i - j)+", j="+j);
//                System.out.println("---------------------------------");
            }
        }

        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }
}
