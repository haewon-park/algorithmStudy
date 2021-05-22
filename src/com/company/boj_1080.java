package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] matrix1 = new char[N][M];
        char[][] matrix2 = new char[N][M];

        for(int i = 0; i < N; i++){
            matrix1[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            matrix2[i] = br.readLine().toCharArray();
        }

        int count = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = 0; j < M - 2; j++){
                if(matrix1[i][j] != matrix2[i][j]){
                    for(int k = i; k < i + 3; k++){
                        for(int l = j; l < j + 3; l++){
                            if(matrix1[k][l] == '1'){
                                matrix1[k][l] = '0';
                            } else{
                                matrix1[k][l] = '1';
                            }
                        }
                    }
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(matrix1[i][j] != matrix2[i][j]){
                    count = -1;
                    break;
                }
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}