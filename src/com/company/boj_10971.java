package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_10971 {
    static int[][] w;
    static int N;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            dfs(i, i, 0, 0);
        }

        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int i, int count, int sum){
        if(count == N && start == i){
            min = Math.min(min, sum);
            return;
        }

        for(int j = 0; j < N; j++){
            if(w[i][j] == 0){
                continue;
            }

            if(!visited[i] && w[i][j] > 0){
                visited[i] = true;
                sum += w[i][j];
                dfs(start, j, count + 1, sum);
                sum -= w[i][j];
                visited[i] = false;
            }
        }
    }
}
