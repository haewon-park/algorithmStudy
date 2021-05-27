// map[a][b] = 1 --> a행의 b열과 b+1열 사이에 가로선이 있다는 뜻
// 사다리를 내려갈때 현위치가 1이면 오른쪽으로 가로선이 있다고 생각하고, 현위치 왼쪽에 1이 있다면 왼쪽으로 가로선이 있다고 생각
// 백트리킹 적으로 사다리를 놓고 빼고를 반복하여 완전탐색

package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_15684 {
    static int N, M, H;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean isEnd = false;

    public static boolean startGame(){
        for(int i = 1; i <= N; i++){
            int index = i;
            int depth = 1;
            while (depth <= H){
                if(map[depth][index] == 1){
                    index += 1;
                } else if(map[depth][index - 1] == 1){
                    index -= 1;
                }
                depth++;
            }

            if(index == i){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void solve(int count, int max){
        if(isEnd){
            return;
        }
        if(max == count){
            if(startGame()){
                isEnd = true;
            }
            return;
        }

        for(int i = 1; i <= H; i++){
            for(int j = 1; j < N; j++){
                if(map[i][j-1] == 0 && map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    solve(count + 1, max);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        if(M == 0){
            ans = 0;
        } else{
            for(int i = 0; i <= 3; i++){
                solve(0, i);
                if(isEnd){
                    ans = i;
                    break;
                }
            }
        }

        if(ans > 3){
            ans = -1;
        }

        bw.write(ans + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
