package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Sorting_1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 0;

        for(int i=0; i<N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        if(pq.size()==1) {
            System.out.println(0);
            return;
        }

        while(!pq.isEmpty()) {
            long a = pq.poll();
            long b = pq.poll();

            ans += a;
            ans += b;

            if(!pq.isEmpty())
                pq.add(a+b);
        }
        System.out.println(ans);
    }
}
