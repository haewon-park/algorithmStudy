package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1987 {
    static int R, C, result = 0;
    static char[][] map;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int r, int c, int count){
        if(result == 26){
            return;
        }

        int[] rDirection = {-1, 0, 1, 0};
        int[] cDirection = {0, -1, 0, 1};

        for(int i = 0; i < 4; i++) {
            int rA = r + rDirection[i];
            int cA = c + cDirection[i];

            if(rA < 0 || cA < 0 || rA >= R || cA >= C){
                continue;
            }

            if(visited[map[rA][cA] - 'A']){
                continue;
            }

            visited[map[rA][cA] - 'A'] = true;
            dfs(rA, cA, count + 1);
            visited[map[rA][cA] - 'A'] = false;
        }
        result = Math.max(result, count);
    }
}
