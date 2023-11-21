// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// Solution.java

import java.util.*;

class Solution {
    boolean[] visited;
    String BEGIN;
    String TARGET;

    public int solution(String begin, String target, String[] words) {
        BEGIN = begin;
        TARGET = target;
        visited = new boolean[words.length];
        
        int answer = bfs(words);
        return answer;
    }
    public int bfs(String[] words){
        Queue<String[]> step = new LinkedList<>();
        // current[1]은 단계를 의미함
        step.add(new String[] {BEGIN, "0"});
        while(!step.isEmpty()){
            String[] current = step.poll();
            String word = current[0];
            int cnt = Integer.valueOf(current[1]);
            
            if(word.equals(TARGET)){
                return cnt;
            }
            for(int i = 0; i < words.length; i++){
                int equalCnt = 0;
                if(visited[i] == true) continue;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) == word.charAt(j)){
                        equalCnt++;
                    }
                }
                if(equalCnt == word.length() - 1){
                    visited[i] = true;
                    step.add(new String[] {words[i], Integer.toString(cnt+1)});
                }
            }
        }
        return 0;
    }
}
