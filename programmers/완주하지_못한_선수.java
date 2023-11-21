// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// Solution.java

import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> part = new HashMap<>();
        for(String p : participant){
            part.put(p, part.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            part.put(c, part.get(c) - 1);
        }
        
        for(String key : part.keySet()){
            if(part.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
