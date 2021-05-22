package com.company;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    static class tower{
        int index, height;

        tower(int index, int height){
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Stack<tower> towers = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i = 1; i <= num; i++){
            int height = Integer.parseInt(st.nextToken());

            if(towers.isEmpty()){
                result.append("0 ");
                towers.push(new tower(i, height));
            } else{
                while(true){
                    if(towers.isEmpty()) {
                        result.append("0 ");
                        towers.push(new tower(i, height));
                        break;
                    }

                    tower top = towers.peek();

                    if(top.height > height){
                        result.append(top.index + " ");
                        towers.push(new tower(i, height));
                        break;
                    } else{
                        towers.pop();
                    }
                }
            }
        }

        bw.write(result.toString() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
