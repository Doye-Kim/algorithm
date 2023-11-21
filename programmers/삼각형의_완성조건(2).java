// https://school.programmers.co.kr/learn/courses/30/lessons/120868
// Solution.java

import java.lang.Math;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(int i = 1; i < min + max; i++){
        	// i가 가장 긴 변이 되는 경우
            if(i > max){
                answer++;
            }
        	// 기존의 max가 가장 긴 변이 되는 경우 (i가 max와 같을 수 있음!)
            else if(i > max - min){
                answer++;
            }
        }
        return answer;
    }
}
