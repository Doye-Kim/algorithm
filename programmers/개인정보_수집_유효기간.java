// https://school.programmers.co.kr/learn/courses/30/lessons/150370
// Solution.java

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        Map<Character, Integer> term = new HashMap<>();
        String[] privacy;
        
        for(int i = 0; i < terms.length; i++){
            String[] t = terms[i].split(" ");
            term.put(t[0].charAt(0), Integer.parseInt(t[1]));
        }
        
        String[] to = today.split("\\.");
        int[] tt = new int[3];
        for(int i = 0; i < 3; i++){
            tt[i] = Integer.parseInt(to[i]);
        }
        for(int i = 0; i < privacies.length; i++){
            privacy = privacies[i].split(" ");
            int t = term.get(privacy[1].charAt(0));
            if(end(tt, privacy[0], t) == true){
                answerList.add(i+1);
            }
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
    
    public boolean end(int[] today, String privacy, int term){
        String[] d = privacy.split("\\.");
        int[] day = new int[3];
        for(int i = 0; i < 3; i++){
            day[i] = Integer.parseInt(d[i]);
        }
        if(day[1] + term > 12) {
            day[0] += (day[1] + term) / 12;
            if((day[1] + term) % 12 == 0) day[0]--;
        }
        day[1] = (day[1] += term) % 12;
        if(day[1] == 0) day[1] = 12;

        if(today[0] > day[0]) return true; 
        else if(today[0] == day[0] && today[1] > day[1]) return true;
        else if(today[0] == day[0] && today[1] == day[1] && today[2] >= day[2]) return true;
        else return false;
    }
}
