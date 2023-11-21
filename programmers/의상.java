// https://school.programmers.co.kr/learn/courses/30/lessons/42578
// Solution.java

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String c = clothes[i][1];
            clothesMap.put(c, clothesMap.getOrDefault(c, 0) + 1);
        }
        for(String k : clothesMap.keySet()){
            answer *= clothesMap.get(k) + 1;
        }      
        return --answer;
    }
}
