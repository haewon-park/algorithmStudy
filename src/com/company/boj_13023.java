package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_13023 {
    static ArrayList<Integer>[] person;
    static boolean[] visited;
    static int result;

    static void dfs(int i, int depth){
        if(depth == 5 || result == 1){
            result = 1;
            return;
        }

        visited[i] = true;

        for(int j = 0; j < person[i].size(); j++){
            if(!visited[person[i].get(j)]){
                visited[person[i].get(j)] = true;
                dfs(person[i].get(j), depth + 1);
                visited[person[i].get(j)] = false;
            }
        }

        visited[i] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        person = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            person[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int personA = Integer.parseInt(st.nextToken());
            int personB = Integer.parseInt(st.nextToken());
            person[personA].add(personB);
            person[personB].add(personA);
        }

        result = 0;
        for(int i = 0; i < N; i++){
            dfs(i, 1);
            if(result == 1){
                break;
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
