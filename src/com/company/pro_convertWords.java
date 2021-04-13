package com.company;

import java.util.*;

public class pro_convertWords {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int[] dist;
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        //target 단어가 없는 경우
        int target_index = -1;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(target)) {
                target_index = i+1;
                break;
            }
        }
        if(target_index == -1) return 0;

        //isConvert인 경우 간선을 이어주고 bfs
        list = new ArrayList<>();
        String[] s = new String[words.length+1];
        visit = new boolean[s.length];
        dist = new int[s.length];
        for(int i=0; i<s.length; i++) list.add(new ArrayList<>());
        s[0] = begin;
        for(int i=1; i<s.length; i++) {
            s[i] = words[i-1];
        }
        for(int i=0; i<s.length-1; i++) {
            for(int j=i+1; j<s.length; j++) {
                if(isConvert(s[i], s[j])) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        bfs(0);
        answer = dist[target_index];
        return answer;
    }

    //현재 단어에서 한 글자만 다른 경우 true
    public static boolean isConvert(String word, String convertWord) {
        int count = 0;
        for(int i=0; i<word.length(); i++ ) {
            if(word.charAt(i) != convertWord.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
    public static void bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        visit[now] = true;
        q.offer(now);
        while(!q.isEmpty()) {
            int next = q.poll();
            for(int i=0; i<list.get(next).size(); i++) {
                int n = list.get(next).get(i);
                if(!visit[n]) {
                    visit[n] = true;
                    dist[n] = dist[next] + 1;
                    q.offer(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", s));
        String[] s1 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution("hit", "cog", s1));
    }

}
