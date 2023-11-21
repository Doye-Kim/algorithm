// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// Solution.java

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 배열 원소의 크기가 0~9이므로 첫번째 비교 대상에 -1을 넣음
        int cmp= -1;
        
        for(int i = 0; i < arr.length; i++){
        	// 값이 달라지면 cmp 갱신하고 ArrayList에 추가
            if(cmp != arr[i]){
                cmp = arr[i];
                list.add(cmp);
            }
        }
        // ArrayList to array
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}
