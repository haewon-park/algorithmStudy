package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> fruits = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            fruits.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(fruits);

        while(fruits.size()>0){
            if(fruits.get(0) <= L){
                L++;
                fruits.remove(0);
            } else{
                break;
            }
        }

        bw.write(L + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
