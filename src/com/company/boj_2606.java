package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2606 {
    static int virus = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int pairs = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<Integer>());
        }

        int vertex1, vertex2;

        for(int i = 0; i < pairs; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        virus = 0;
        dfs(1);

        bw.write(virus + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int startIndex){
        visited[startIndex] = true;

        int next;
        for(int i = 0; i < graph.get(startIndex).size(); i++){
            next = graph.get(startIndex).get(i);
            if(!visited[next]){
                visited[next] = true;
                virus++;
                dfs(next);
            }
        }
    }
}
