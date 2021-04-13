package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_searchMaze {
    public static class Location {
        int row, col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int arr[][];
    static int isVisit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        isVisit = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }

        bfs();
    }


    public static void bfs() throws IOException {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1, 1));

        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        isVisit[1][1] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            for (int i = 0; i < 4; i++) {
                int x = row + xArr[i];
                int y = col + yArr[i];

                if (checkLocation(x, y)) {
                    queue.add(new Location(x, y));
                    isVisit[x][y] = isVisit[row][col] + 1;
                }
            }
        }
        bw.write( isVisit[n][m] +  "\n");
        bw.flush();
        bw.close();
    }


    public static boolean checkLocation(int row, int col) {
        // 범위 밖 노드인 경우
        if (row < 1 || row > n || col < 1 || col > m) {
            return false;
        }

        // 방문한 노드인 경우
        if (isVisit[row][col] != 0 || arr[row][col] == 0) {
            return false;
        }

        return true;
    }

}
