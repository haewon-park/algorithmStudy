package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Geometry_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        bw.write(ccw(x1, y1, x2, y2, x3, y3) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);

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
}