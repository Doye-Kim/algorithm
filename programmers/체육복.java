// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// Solution.java

import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        HashSet<Integer> borrow = new HashSet<>();
        for(int r: reserve){
            borrow.add(r);
        }
        //잃어버린 사람과 여분 있는 사람이 같을 때
        for(int i = 0; i < lost.length; i++){
            if(borrow.contains(lost[i])){
                borrow.remove(lost[i]);
                lost[i] = -1;
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            if(borrow.contains(lost[i] - 1)){
                borrow.remove(lost[i] - 1);
                lost[i] = -1;
            }
            else if(borrow.contains(lost[i] + 1)){
                borrow.remove(lost[i] + 1);
                lost[i] = -1;
            }
            else if(lost[i] == -1) continue;
            else answer--;
        }
        return answer;
    }
}
