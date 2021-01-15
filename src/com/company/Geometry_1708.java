package com.company;

import java.io.*;
import java.util.*;

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Geometry_1708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        bw.write(grahamScan(points) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

    static int grahamScan(ArrayList<Point> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).y < root.y) {
                root = input.get(i);
            } else if (input.get(i).y == root.y) {
                if (input.get(i).x < root.x) {
                    root = input.get(i);
                }
            }
        }

        input.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int result = ccw(root, p1, p2);

                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                } else {
                    long distance1 = calDist(root, p1);
                    long distance2 = calDist(root, p2);

                    if (distance1 > distance2) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.add(root);

        for (int i = 1; i < input.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), input.get(i)) <= 0)) {    // first, second, next
                stack.pop();
            }
            stack.add(input.get(i));
        }

        return stack.size();
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);

        //ccw
        if (result > 0) {
            return 1;
        }
        //parallel
        else if (result == 0) {
            return 0;
        }
        //cw
        else {
            return -1;
        }
    }

    static long calDist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}