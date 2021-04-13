package com.company;

import java.util.Arrays;

public class pro_CCTV {
    public int solution(int[][] routes) {
        int answer = 0;
        int count = -30001;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] route : routes) {
            if (count < route[0]) {
                count = route[1];
                answer++;
            }
        }

        return answer;
    }
}
