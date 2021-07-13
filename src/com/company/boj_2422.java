package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++){
            Arrays.fill(arr[i], 0);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                if(arr[i][j] == 0){
                    for(int k = j + 1; k <= N; k++){
                        if(arr[i][k] == 0 && arr[k][j] == 0){
                            count++;
                        }
                    }
                }
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
