package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()), area = 0;
        boolean[][] check = new boolean[101][101];

        for(int count = 0; count < num; count++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    if(check[i][j]){    //이미 칠해진 좌표인지 확인
                        continue;
                    }
                    check[i][j] = true;
                    area++;
                }
            }
        }

        bw.write(area + "\n");

        bw.flush();
        br.close();
        br.close();
    }
}
