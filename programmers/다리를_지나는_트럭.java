// https://school.programmers.co.kr/learn/courses/30/lessons/42583
// Solution.java

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        //answer == time
        //다리에 트럭이 새로 올라갈 때만 answer++를 해줌
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
            	//다리(=큐)가 아예 비어있는 경우
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                //다리가 꽉 찬 경우
                else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }
                //트럭이 몇 대 더 올라갈 수 있는 경우
                else{
                	//현재 다리 위 트럭 무게 + 다음 트럭의 무게가
                    //다리의 무게 제한보다 가벼운 경우
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                    else{
                    	//다리의 무게 제한을 넘었으니 큐에 0을 넣어 빈 자리를 채움
                        //0을 넣어 자리를 채웠으니 answer++;
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
       	//마지막에 있는 트럭이 지나가는 시간을 더해줌
        return answer + bridge_length;
    }
}
