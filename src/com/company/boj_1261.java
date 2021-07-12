package com.company;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1261 {
    static int[][] maze = null;
    static int[][] distance = null;

    static class point{
        int r, c, broke;

        public point(int r, int c, int broke) {
            this.r = r;
            this.c = c;
            this.broke = broke;
        }
    }

    static void bfs(){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        maze = new int[n + 1][m + 1];

        boolean visit[][] = new boolean[n+1][m+1];
        for(int y= 1 ; y <=n ;y++) {
            char temp[] = br.readLine().toCharArray();
            for(int x = 1 ; x <= m ; x++) {
                if(temp[x-1]=='1') {
                    maze[y][x] =1;
                }
            }
        }
        PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {
            public int compare(point o1, point o2) {
                if(o1.broke > o2.broke) return 1;
                else if(o1.broke == o2.broke) return 0;
                else return -1;
            };
        });

        pq.add(new point(1,1,0));
        visit[1][1]= true;

        int answer =0;
        int dir[][] = {{1,0},{-1,0}, {0,1}, {0,-1}};

        while(!pq.isEmpty()) {
            point now = pq.poll();
            int r = now.r;
            int c = now.c;
            int broke =  now.broke;

            if( r == n && c == m) {
                answer = broke;
                break;
            }

            for(int i = 0 ; i <4 ; i++) {
                int ny = r + dir[i][0];
                int nx = c + dir[i][1];
                if(ny > 0 && nx > 0 && ny <= n && nx <= m) {
                    if(!visit[ny][nx]) {
                        if(maze[ny][nx] == 1) {
                            visit[ny][nx] = true;
                            pq.add(new point(ny, nx,broke + 1));
                        } else if(maze[ny][nx] == 0) {
                            visit[ny][nx] = true;
                            pq.add(new point(ny, nx, broke));
                        }
                    }
                }
            }
        }
        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}