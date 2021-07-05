package com.company;

import java.io.*;

public class boj_3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        str[str.length - 1] = str[str.length - 1].substring(0, str[str.length - 1].length() - 1);

        for(int i = 1; i < str.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str[0]);
            int temp = 0;
            for(int j = str[i].length() - 1; j >= 0; j--){
                if (str[i].charAt(j) == '*') {
                    sb.append("*");
                } else if(str[i].charAt(j) == '&'){
                    sb.append("&");
                } else if(str[i].charAt(j) == ']'){
                    sb.append("[]");
                } else if(str[i].charAt(j) == '['){
                    continue;
                } else if(str[i].charAt(j) == ','){
                    continue;
                } else{
                    temp = j;
                    break;
                }
            }

            if(temp == 0){
                sb.append(" " + str[i].charAt(0));
                bw.write(sb + ";\n");
            } else{
                sb.append(" " + str[i].substring(0, temp + 1));
                bw.write(sb + ";\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
