package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_15662 {
    static int T;
    static LinkedList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        T = Integer.parseInt(br.readLine());
        list = new LinkedList[T];
        for(int i = 0; i < T; i++){
            list[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < 8; j++){
                list[i].add(Character.getNumericValue(str.charAt(j)));
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            ccw(index, - direction);
            cw(index, - direction);
            rotate(index, direction);
        }

        for(int i = 0; i < T; i++){
            if(list[i].get(0) == 1){
                count++;
            }
        }

        bw.write(count + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void ccw(int index, int directon) {
        if(index - 1 >= 0  && list[index - 1].get(2) != list[index].get(6)){
            ccw(index - 1, - directon);
            rotate(index - 1, directon);
        }
    }

    static void cw(int index, int directon) {
        if(index + 1 < T && list[index + 1].get(6) != list[index].get(2)){
            cw(index + 1, - directon);
            rotate(index + 1, directon);
        }
    }

    static void rotate(int index, int directon) {
        if(directon == 1){
            list[index].addFirst(list[index].pollLast());
        } else{
            list[index].addLast(list[index].pollFirst());
        }
    }
}
