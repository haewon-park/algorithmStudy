package com.company;

//참고: https://degurii.tistory.com/46

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Geometry_2170 {

    static class point {
        long x, y;

        point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        ArrayList<point> points = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        points.sort(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if(o1.x > o2.x) {
                    return 1;
                }
                else if((o1.x == o2.x) && (o1.y > o2.y)) {
                    return 1;
                }
                return -1;
            }
        });

        long s = points.get(0).x;
        long e = points.get(0).y;
        long dist = e - s;

        for (int i = 1; i < points.size(); i++) {
            long ns = points.get(i).x;
            long ne = points.get(i).y;

            if ((s <= ns) && (ne <= e)) {   //한 선분에 다른 선분이 포함
                continue;
            }
            else if (ns < e) {              //두 선분이 겹
                dist += -(e - ns) + (ne - ns);
            }
            else {                          //겹치지 않는 경우
               dist += ne - ns;
            }
            s = ns;
            e = ne;
        }

        bw.write(dist + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
