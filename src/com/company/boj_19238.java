package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_19238 {
    static class passenger {
        int srcX, srcY, destX, destY;

        public passenger(int srcY, int srcX, int destY, int destX) {
            this.srcX = srcX;
            this.srcY = srcY;
            this.destX = destX;
            this.destY = destY;
        }
    }

    static class taxi {
        int x, y, energy, passInfo;

        public taxi(int y, int x, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }
    }

    public static int process(int[][] map, passenger[] pArr, taxi taxi, int N, int M) {
        for (int i = 0; i < M; i++) { //총 승객 수 만큼
            //거리가 가장 짧은 승객 --> 택시 승객에게 이동
            if (bfs(map, pArr, taxi, N)){
                if (move(map, pArr, taxi, N)) {
                } else { // 승객 목적지 이동 불가
                    return -1;
                }
            } else{
                return -1;
            }
        }
        return taxi.energy;
    }

    public static boolean bfs(int[][] map, passenger[] pArr, taxi taxi, int N){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        //현재 택시 위치
        queue.offer(new int[] {taxi.y, taxi.x, taxi.energy});
        visited[taxi.y][taxi.x] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            //가장 가까운 승객의 위치 정보
            int minY = N + 1;
            int minX = N + 1;
            boolean flag = false;

            //같은 거리의 승객이 여러명 있을 수 있음으로 사이즈 별로 반복
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int y = pos[0];
                int x = pos[1];
                int energy = pos[2];

                //승객 발견 --> 태울 승객 찾기
                if(map[y][x] > 1){
                    if(minY > y){
                        minY = y;
                        minX = x;
                    } else if(minY == y){
                        if(minX > x){
                            minY = y;
                            minX = x;
                        }
                    }
                    flag = true;
                    //에너지 소모 할당
                    taxi.energy = energy;
                    continue;
                }
                //에너지 다씀
                if(energy <= 0){
                    return false;
                }

                for(int j = 0; j < 4; j++){
                    int nextY = y + dy[j];
                    int nextX = x + dx[j];

                    if(rangeCheck(nextY, nextX, N) || visited[nextY][nextX] || map[nextY][nextX] == 1){
                        continue;
                    }

                    queue.offer(new int[] {nextY, nextX, energy - 1});
                    visited[nextY][nextX] = true;
                }
            }
            if(flag){
                taxi.y = minY;
                taxi.x = minX;
                taxi.passInfo = map[minY][minX];
                map[minY][minX] = 0;
                return true;
            }
        }
        return false;
    }

    public static boolean move(int[][] map, passenger[] pArr, taxi taxi, int N){
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        passenger cur = pArr[taxi.passInfo];

        queue.offer(new int[] {taxi.y, taxi.x, taxi.energy});
        visited[taxi.y][taxi.x] = true;

        while(!queue.isEmpty()){
//            int size = queue.size();
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            int energy = pos[2];

            //도착
            if(y == cur.destY && x == cur.destX){
                taxi.y = y;
                taxi.x = x;
                taxi.energy = energy + 2 * (taxi.energy - energy);
                return true;
            }

            //에너지 떨어짐
            if(energy <= 0){
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(rangeCheck(nextY, nextX, N) || visited[nextY][nextX]||map[nextY][nextX] == 1){
                    continue;
                }

                queue.offer(new int[] {nextY, nextX, energy - 1});
                visited[nextY][nextX] = true;
            }
        }
        //도착 못하는 경우
        return false;
    }

    public static boolean rangeCheck(int nextY, int nextX, int N){
        return nextY <= 0 || nextY >= N + 1 || nextX <= 0 || nextX >= N + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        taxi taxi = new taxi(y, x, E);
        passenger[] pArr = new passenger[M + 2];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int srcY = Integer.parseInt(st.nextToken());
            int srcX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());
            int destX = Integer.parseInt(st.nextToken());
            pArr[i + 2] = new passenger(srcY, srcX, destY, destX);
            map[srcY][srcX] = i + 2;
        }

        int result = process(map, pArr, taxi, N, M);
        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}