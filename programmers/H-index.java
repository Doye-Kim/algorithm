// https://school.programmers.co.kr/learn/courses/30/lessons/42747
// Solution.java

import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = citations.length - 1; i > -1; i--){
            System.out.println(i+1 +" " + citations[i]);
            if(citations.length - i <= citations[i]){
                answer++;
            }
        }
        return answer;
    }
}
