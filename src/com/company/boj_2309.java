package com.company;

import java.io.*;
import java.util.*;

public class boj_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<Integer>();
        int sum = 0;

        for(int i = 0; i < 9; i++){
            arr.add(Integer.parseInt(br.readLine()));
            sum += arr.get(i);
        }
        Collections.sort(arr);

        outer:
        for(int i = 0; i < 9; i++){
            int first = arr.get(i);
            for(int j = i + 1; j < 9; j++){
                int second = arr.get(j);
                if(first + second + 100 == sum){
                    arr.remove((Integer)first);
                    arr.remove((Integer)second);
                    break outer;
                }
            }
        }

        for(int a : arr){
            bw.write(a + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
