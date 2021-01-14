package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sorting_13415 {
    final static int ASCEND = 1;
    final static int DESCEND = -1;
    public static void main(String[] args) throws IOException {

        int N;
        Integer[] numArr;
        Integer[] sortedArr;

        int K;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        numArr = new Integer[N];
        sortedArr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            numArr[i] = temp;
            sortedArr[i] = temp;
        }

        K = Integer.parseInt(br.readLine());
        SortingGame sortingGame = new SortingGame();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            sortingGame.pushOrder(Integer.parseInt(st.nextToken()), ASCEND);
            sortingGame.pushOrder(Integer.parseInt(st.nextToken()), DESCEND);
        }

        sortingGame.sort(numArr, sortedArr);

        for (int i = 0; i < N; i++) {
            bw.write(sortedArr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class SortingGame {
    private Deque<Integer> sortingOrder;

    public SortingGame() {
        sortingOrder = new LinkedList<Integer>();
    }

    public void pushOrder(int index, int direction) {
        while (!sortingOrder.isEmpty() && Math.abs(sortingOrder.getLast()) <= index) {
            sortingOrder.removeLast();
        }
        sortingOrder.addLast(index * direction);
    }

    public void sort(Integer[] numArr, Integer[] sortedArr) {
        int maxValue = Math.abs(sortingOrder.getFirst());
        Arrays.sort(numArr, 0, maxValue);

        int ascendIdx = maxValue - 1;
        int descendIdx = 0;
        int sortedArrIdx = maxValue - 1;

        while (!sortingOrder.isEmpty()) {
            int currentOrder = sortingOrder.removeFirst();
            int nextOrder = sortingOrder.isEmpty() ? 0 : sortingOrder.getFirst();
            int length = Math.abs(currentOrder) - Math.abs(nextOrder);

            if (currentOrder < 0) {

                for (int i = 0; i < length; i++) {

                    sortedArr[sortedArrIdx--] = numArr[descendIdx++];
                }
            }

            else {
                for (int i = 0; i < length; i++) {
                    sortedArr[sortedArrIdx--] = numArr[ascendIdx--];
                }
            }

            currentOrder = nextOrder;
        }
    }
}


