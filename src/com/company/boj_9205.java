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
            //boolean, Boolean의 차이
            //참고: https://vesselsdiary.tistory.com/67

            for(int j = 0; j < n + 1; j++){
                st = new StringTokenizer(br.readLine()," ");
                map[j] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine()," ");
            map[n + 1] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            //BFS
//            Arrays.fill(visited, false);
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

                for(int j = 0; j < n + 2; j++){ //n+2 --> 편의점 개수 + start + end
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

// 소영이가 푼 플로이드 워셜
// O(n^3)
//import java.util.Scanner;
//
//public class boj9205{
//    public static void main(String[]ar){
//        Scanner sc = new Scanner(System.in);
//        int test_case = sc.nextInt();
//
//        for(int t=0; t<test_case; t++){
//            int n = sc.nextInt();
//            int[] x = new int[n+2];
//            int[] y = new int[n+2];
//            int[][] map = new int[n+2][n+2];
//
//            for(int i=0; i<n+2; i++){
//                x[i] = sc.nextInt();
//                y[i] = sc.nextInt();
//            }
//
//            for(int i=0; i<n+2; i++){
//                map[i][i]=1;
//                for(int j=i+1; j<n+2; j++){
//                    int distance = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
//                    if(distance<=1000)
//                        map[i][j] = map[j][i] = 1;
//                }
//            }
//
//            // 플로이드
//            for(int k=0; k<n+2; k++){
//                for(int i=0; i<n+2; i++){
//                    for(int j=0; j<n+2; j++){
//                        if(map[i][k]==1 && map[k][j]==1)
//                            map[i][j] = 1;
//                    }
//                }
//            }
//
//            if(map[0][n+1]==1)
//                System.out.println("happy");
//            else
//                System.out.println("sad");
//        }
//    }
//}
