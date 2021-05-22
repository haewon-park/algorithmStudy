package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class boj_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<>();

        int max = 0;

        for(int i = 0; i < num; i++){
            String line = br.readLine();
            if(books.containsKey(line)){
                books.put(line, books.get(line) + 1);
            } else{
                books.put(line, 1);
            }
            if(books.get(line) > max){
                max = books.get(line);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String key : books.keySet()){
            if(books.get(key) == max){
                list.add(key);
            }
        }

        Collections.sort(list);
        bw.write(list.get(0) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
