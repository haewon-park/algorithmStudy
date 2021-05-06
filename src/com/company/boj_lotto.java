package com.company;

import java.io.*;

public class boj_lotto {
    static String[] line;
    static boolean[] visit;
    static int n;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            line = br.readLine().split("\\s");
            n = Integer.parseInt(line[0]);
            visit = new boolean[n+1];

            if(n == 0) {
                break;
            }

            dfs(1, 0);

            bw.write( "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int v, int d) throws IOException {
        if(d == 6) {
            String str = "";
            for(int i = 1; i <= n; i++) {
                if(visit[i]) str += line[i] + " ";
            }
            bw.write(str + "\n");
            return;
        }

        for(int i = v; i <= n; i++) {
            visit[i] = true;
            dfs(i + 1, d + 1);
            visit[i] = false;
        }
    }
}
