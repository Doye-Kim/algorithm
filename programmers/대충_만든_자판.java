// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// Solution.java
import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minKeymap = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                char now = keymap[i].charAt(j);
                if(!(minKeymap.containsKey(now))){
                    minKeymap.put(now, j + 1);
                }
                else if((j + 1) < minKeymap.get(now)){
                    minKeymap.put(now, j + 1);
                }
                else continue;
            }
        }
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                char now = targets[i].charAt(j);
                if(minKeymap.containsKey(now)){
                    answer[i] += minKeymap.get(now);
                }
                else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
