// https://school.programmers.co.kr/learn/courses/30/lessons/42627
// Solution.java

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int end, sum, jobIndex, cnt;
        end = sum = jobIndex = cnt = 0;
        
        while(cnt < jobs.length){
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= end){
                pQ.add(jobs[jobIndex++]);
            }
            if(pQ.isEmpty()){
                end = jobs[jobIndex][0];
            }
            else{
                int[] p = pQ.poll();
                sum += end + p[1] - p[0];
                end += p[1];
                cnt++;
            }
        }
        return sum / jobs.length;
    }
}
