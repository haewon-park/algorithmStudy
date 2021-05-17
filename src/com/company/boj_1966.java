package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//참고: https://wellohorld.tistory.com/104
public class boj_1966 {
    static class file {
        int index, priority;

        public file(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<file> list = new ArrayList<file>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                list.add(new file(j, Integer.parseInt(st.nextToken())));
            } //input

            int order = 1;

            base:
            while (!list.isEmpty()) {
                file f = list.get(0); //첫번째를 기준으로 Loop
                for (int j = 1; j < list.size(); j++) {
                    if (f.priority < list.get(j).priority) { //우선순위 비교해서
                        list.remove(0); //0번째 지우고
                        list.add(f);    //0번째 file 새로 맨 뒤에 추가
                        continue base;
                    }
                }

                if (f.index == M) {
                    break;
                }

                list.remove(0);
                order++;
            }
            bw.write(order + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}