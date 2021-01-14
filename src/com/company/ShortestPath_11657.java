package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShortestPath_11657 {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge e[] = new Edge[M];

        long dist[] = new long[N+1];
        for(int i=1; i<=N; i++)
            dist[i] = INF;


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            e[i] = new Edge(u,v,val);
        }

        dist[1] = 0;

        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M; j++) {
                if(dist[e[j].u] == INF){
                    continue;
                }

                if(dist[e[j].v] > (dist[e[j].u] + e[j].val)) {
                    dist[e[j].v] = dist[e[j].u] + e[j].val;
                }
            }
        }

        boolean check = false;
        for(int i=0; i<M; i++) {
            if(dist[e[i].u] != INF && dist[e[i].v] > dist[e[i].u] + e[i].val) {
                check = true;
                break;
            }
        }

        if(check){
            System.out.println(-1);
        }
        else {
            for(int i=2; i<=N; i++) {
                if(dist[i] == INF){
                    System.out.println("-1");
                }
                else{
                    System.out.println(dist[i]);
                }
            }
        }
    }

    public static class Edge{
        int u;
        int v;
        int val;
        public Edge(int u,int v, int val) {
            this.u = u;
            this.v = v;
            this.val = val;
        }
    }
}
