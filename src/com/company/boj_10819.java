package com.company;

//참고: https://hyukjun.tistory.com/223

import java.io.*;
import java.util.StringTokenizer;

public class boj_10819 {
    static int N;
    static int[] A, temp;
    static boolean[] flag;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        temp = new int[N];
        flag = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        bw.write(result + "");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int index){
        if(index == N){
            int sum = 0;
            for(int i = 0; i < N - 1; i++){
                sum += Math.abs(temp[i] - temp[i + 1]);
            }

            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!flag[i]){
                flag[i] = true;
                temp[index] = A[i];
                dfs(index + 1);
                flag[i] = false;
            }
        }
    }
}
