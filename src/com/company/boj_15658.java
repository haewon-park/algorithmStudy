package com.company;

// 참고: https://iamheesoo.github.io/blog//algo-boj15658

import java.io.*;
import java.util.StringTokenizer;

public class boj_15658 {
    static int N;
    static int[] arr;
    static int[] operations;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operations = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        bw.write(max + "\n");
        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int index, int sum){
        if(index == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(operations[0] > 0){
            operations[0]--;
            dfs(index + 1, sum + arr[index]);
            operations[0]++;
        }

        if(operations[1] > 0){
            operations[1]--;
            dfs(index + 1, sum - arr[index]);
            operations[1]++;
        }

        if(operations[2] > 0){
            operations[2]--;
            dfs(index + 1, sum * arr[index]);
            operations[2]++;
        }

        if(operations[3] > 0){
            operations[3]--;
            dfs(index + 1, sum / arr[index]);
            operations[3]++;
        }
    }
}
