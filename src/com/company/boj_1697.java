package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            bw.write(N - K + "\n");
        } else {
            bw.write(bfs(N, K) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] S = new int[100001];

        q.offer(N);
        S[N] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0){
                    next = current - 1;
                } else if (i == 1){
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (next == K){
                    return S[current];
                }

                if (0 <= next && next <= 100000) {
                    if (S[next] == 0) {
                        q.offer(next);
                        S[next] = S[current] + 1;
                    }
                }
            }
        }

        return 0;
    }
}