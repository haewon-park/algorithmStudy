package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class boj_11559 {
    static char map[][] = new char[12][6];
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    static class point{
        int r, c;

        public point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static boolean remove(int r, int c, char color){
        ArrayList<point> list = new ArrayList<>();
        boolean checked[][] = new boolean[12][6];
        LinkedList<point> q = new LinkedList<>();

        list.add(new point(r,c));
        checked[r][c] = true;
        q.add(new point(r, c));

        while (!q.isEmpty()){
            point now = q.poll();
            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int rr = now.r + dr[d];
                int cc = now.c + dc[d];
                // 범위 이탈
                if(rr < 0 || cc < 0 || rr >= 12 || cc >= 6) {
                    continue;
                }
                // 이미 확인한 구간
                if(checked[rr][cc]) {
                    continue;
                }
                // 같은 색 뿌요일 경우
                if(map[rr][cc] == color) {
                    list.add(new point(rr, cc));
                    q.add(new point(rr, cc));
                    checked[rr][cc] = true;
                }
            }
        }

        // 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있다면
        if(list.size() >= 4) {
            // 연결된 같은 색 뿌요들이 한꺼번에 없어짐
            for (point p : list) {
                map[p.r][p.c] = '.';
            }
            return true;
        } else {
            // 4개 이상 연결되지 않았다면
            return false;
        }
    }

    public static void drop(){
        for (int c = 0; c < 6; c++) {
            int empty = -1; // 빈 공간의 행 번호

            for (int r = 12 - 1; r >= 0; r--) {
                // 뿌요가 있는 자리이고, 빈 공간이 없다면
                if(map[r][c] != '.' && empty == -1) {
                    continue;
                }
                    // 처음 발견한 빈 공간
                else if(map[r][c] == '.' && empty == -1) {
                    empty = r;
                }
                    // 뿌요가 있는 자리인데, 빈 공간이 있을 경우
                else if(map[r][c] != '.' && empty != -1) {
                    map[empty][c] = map[r][c];
                    map[r][c] = '.';
                    empty--;
                }
            }
        }
    }

    public static int process(){
        int count = 0;
        while(true) {
            boolean flag = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(map[i][j] == '.'){
                        continue;
                    }
                    if(remove(i, j, map[i][j])){
                        flag = true;
                    }
                }
            }

            if(!flag){
                return count;
            }

            drop();
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 12; i++){ //input
            map[i] = br.readLine().toCharArray();
        }

        bw.write(process() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
