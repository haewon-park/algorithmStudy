package com.company;

import java.io.*;

public class DP_2839 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] defaultab = {-1, -1, -1, 1, -1, 1, 2, -1};

        if (n <= 7) {
            System.out.println(defaultab[n]);
            return;
        }
        else
            for (int i = 0; i <= 7; i++)
                dp[i] = defaultab[i];

        for (int i = 8; i <= n; i++)

            if(dp[i-5] != -1 && dp[i-3] != -1)
                dp[i] = 1 + Math.min(dp[i - 3], dp[i - 5]);

            else if(dp[i-5] == -1 && dp[i-3] != -1)
                dp[i] = 1 + dp[i-3];

            else if(dp[i-5] != -1 && dp[i-3] == -1)
                dp[i] = 1 + dp[i-5];

        bw.write(dp[n] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
