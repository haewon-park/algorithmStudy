package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1325 {
    static int[] computers = new int[10001];
    static ArrayList<Integer> list[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int computerA = Integer.parseInt(st.nextToken());
            int computerB = Integer.parseInt(st.nextToken());
            list[computerA].add(computerB);
        }

//        computers = new int[N + 1];
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, computers[i]);
        }

        for(int i = 1; i <= N; i++){
            if(computers[i] == max){
//                bw.write(i + " ");
                System.out.println(i + " ");
            }
        }

//        br.close();
//        bw.flush();
//        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for(int node : list[start]){
            if(!visited[node]){
                dfs(node);
                computers[node]++;
            }
        }
    }
}
