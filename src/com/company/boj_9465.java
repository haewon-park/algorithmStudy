package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N + 1];    //위치마다 값 저장
            int[][] dp = new int[2][N + 1];     //최대값 만들기 위해!

            for(int j = 0; j < 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int j = 2; j <= N; j++){
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
