// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// Solution.java

import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] first = {1, 2, 3, 4, 5};
        int[] sec = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        int[] cnt = new int[3];
        
        for(int x : answers){
            if(x == first[i]) cnt[0]++;
            if(x == sec[j]) cnt[1]++;
            if(x == third[k]) cnt[2]++;
            
            i++;
            j++;
            k++;
            
            if(x == first[i % first.length]) cnt[0]++;
            if(x == sec[j % sec.length]) cnt[1]++;
            if(x == third[k % third.length]) cnt[2]++;

        }
        int max = 0;
        for(int x : cnt){
            max = max > x ? max : x;
        }
        for(int x = 0; x < cnt.length; x++){
            if(cnt[x] == max){
                answer.add(x + 1);
            }
        }
        int[] result = new int[answer.size()];
        for (int x = 0 ; x < answer.size() ; x++){
         result[x] = answer.get(x);
        }
        
        return result;
    }
}
