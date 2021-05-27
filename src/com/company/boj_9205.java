package com.company;

import java.io.*;
import java.util.*;

public class boj_9205 {
    static class point{
        int x, y;

        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            point[] map = new point[n + 2];
            Boolean[] visited = new Boolean[n + 2];

            for(int j = 0; j < n + 1; j++){
                st = new StringTokenizer(br.readLine()," ");
                map[j] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine()," ");
            map[n + 1] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            //BFS
            Arrays.fill(visited, false);
            String result = "sad";
            Queue<point> queue = new LinkedList<point>();
            queue.offer(map[0]);
            visited[0] = true;
            point cur;

            while(!queue.isEmpty()){
                cur = queue.poll();
                if(cur == map[n + 1]){
                    result = "happy";
                    break;
                }

                for(int j = 0; j < n + 2; j++){
                    int dis = Math.abs(cur.x - map[j].x) + Math.abs(cur.y - map[j].y);
                    if (!visited[j] && dis < 1001) {
                        visited[j] = true;
                        queue.offer(map[j]);
                    }
                }
            }
            sb.append(result).append('\n');
        }

        bw.write(sb + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
