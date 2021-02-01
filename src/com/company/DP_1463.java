package com.company;

import java.io.*;

public class DP_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i + 1 <= n) {
                if (dp[i + 1] == 0) {
                    dp[i + 1] = dp[i] + 1;
                } else {
                    if (dp[i + 1] >= dp[i] + 1) {
                        dp[i + 1] = dp[i] + 1;
                    }
                }
            }

            if (i * 2 <= n) {
                if (dp[i * 2] == 0) {
                    dp[i * 2] = dp[i] + 1;
                } else {
                    if (dp[i * 2] >= dp[i] + 1) {
                        dp[i * 2] = dp[i] + 1;
                    }
                }
            }

            if (i * 3 <= n){
                if(dp[i * 3] == 0){
                    dp[i * 3] = dp[i] + 1;
                } else{
                    if(dp[i * 3] >= dp[i] + 1){
                        dp[i * 3] = dp[i] + 1;
                    }
                }
            }
        }

        bw.write(dp[n] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
