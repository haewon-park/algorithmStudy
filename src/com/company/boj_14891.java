package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14891 {
    static char[][] gears;
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gears = new char[5][8];

        for(int i=1; i<=4; i++) {
            gears[i] = br.readLine().toCharArray();
        }
        int turn = Integer.parseInt(br.readLine());
        for(int i=0; i<turn; i++){
            st = new StringTokenizer(br.readLine());
            int wheel_num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[5];
            visited[wheel_num] = true;
            spin(wheel_num, direction, visited);
        }

        printResult();
    }

    public static void spin(int w_num, int d, boolean[] visited){

        if(d==1){ // 시계방향
            char tmp = gears[w_num][7];
            for(int i=7; i>0; i--) {
                gears[w_num][i] = gears[w_num][i-1];
            }
            gears[w_num][0] = tmp;
        }else{  // 반시계방향
            char tmp = gears[w_num][0];
            for(int i=0; i<7; i++) {
                gears[w_num][i] = gears[w_num][i+1];
            }
            gears[w_num][7] = tmp;
        }
        if (w_num - 1 >= 1 && !visited[w_num-1]) { // 왼쪽에 톱니바퀴가 있으면
            visited[w_num-1] = true;
            if(gears[w_num][6+d]!=gears[w_num-1][2]){
                spin(w_num - 1, -d, visited);
            }
        }
        if (w_num + 1 <= 4 && !visited[w_num+1]) { // 오른쪽에 톱니바퀴가 있으면
            visited[w_num+1] = true;
            if(gears[w_num][2+d]!=gears[w_num+1][6]){
                spin(w_num + 1, -d, visited);
            }
        }
    }

    public static void printResult() {
        int sum = 0;
        for(int i=1; i<=4; i++){
            if(gears[i][0] == '1'){
                sum += Math.pow(2, i - 1);
            }
        }
        System.out.println(sum);
    }
}