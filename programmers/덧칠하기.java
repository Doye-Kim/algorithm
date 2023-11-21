// https://school.programmers.co.kr/learn/courses/30/lessons/161989
// Solution.java

class Solution {
    public int solution(int n, int m, int[] section) {
    
        int answer = 0;
        
        int start = section[0];
        answer++;
        
        for(int item : section){
        //롤러로 칠한 부분(start + m)이 다음에 칠해야 할 벽도 칠했으면 continue 
            if(start + m > item) continue;
            start = item;
            answer++;
        }
        return answer;
    }
}
