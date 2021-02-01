package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_6487 {

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void getRelation(Point p1, Point p2, Point p3, Point p4) throws IOException {
        float a1 = (float) 0;
        float a2 = (float) 0;
        float b1 = (float) 0;
        float b2 = (float) 0;
        float same1 = (float) 0;
        float same2 = (float) 0;

        if (p2.x == p1.x) {
            same1 = p1.x;
        }
        else {
            a1 = (float) (p2.y - p1.y) / (p2.x - p1.x);
            b1 = (float) p1.y - a1 * p1.x;
        }

        if (p4.x == p3.x) {
            same2 = p3.x;
        }
        else {
            a2 = (float) (p4.y - p3.y) / (p4.x - p3.x);
            b2 = (float) p3.y - a2 * p3.x;
        }

        if (same1 != 0 || same2 != 0) {
            if (same1 == same2) {
                bw.write("LINE\n");
            }
            else if (same1 != 0 && same2 != 0) {
                bw.write("NONE\n");
            }
            else {
                if (p1.x == p2.x) {
                    bw.write("POINT " + String.format("%.2f", same1) + " " + String.format("%.2f", a2 * same1 + b2) + "\n");
                }
                if (p3.x == p4.x) {
                    bw.write("POINT " + String.format("%.2f", same2) + " " + String.format("%.2f", a1 * same2 + b1) + "\n");
                }
            }
        }
        else if (a1 == a2) {
            if (b1 == b2) {
                bw.write("LINE\n");
            }
            else {
                bw.write("NONE\n");
            }
        }
        else {
            float x = -(b1 - b2) / (a1 - a2);
            float y = a1 * x + b1;
            bw.write("POINT " + String.format("%.2f", x) + " " + String.format("%.2f", y) + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 점 4개 입력 받기
            for (int j = 1; j <= 4; j++) {
                points[j] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            getRelation(points[1], points[2], points[3], points[4]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}