// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// Solution.java

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	//완성까지 걸리는 일수를 queue에 순서대로 넣음
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < speeds.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                queue.offer((100 - progresses[i]) / speeds[i]);
            }
            else{
                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        int size = queue.size();
        int standard = queue.poll(); //배포 기준일
        while(!queue.isEmpty()){
            if(standard >= queue.peek()){
                queue.poll();
            }
            else{
                answer.add(size - queue.size());
                size = queue.size();
                standard = queue.poll();
            }
        }
        //queue가 비었을 때, 즉 마지막 배포는 계산이 안 되었기 때문에 add 해줌
        answer.add(size);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
