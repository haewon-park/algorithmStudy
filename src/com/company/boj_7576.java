package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;

    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int bfs(){
        Queue<tomato> tomatoes = new LinkedList<tomato>();
        int result = 0;

        //토마토가 있는 좌표를 찾아서 Queue에 넣기
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    tomatoes.offer(new tomato(i, j, 0));
                }
            }
        }

        while(!tomatoes.isEmpty()){
            tomato temp = tomatoes.poll();
            result = temp.day;

            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        tomatoes.add(new tomato(nx, ny, result + 1));
                    }
                }
            }
        }

        //토마토가 다 익었는지 확인
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    return -1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
