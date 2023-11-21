// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// Solution.java

import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {'
    //폰켓몬 번호들을 pkmon HashSet에 넣어 중복을 제거한다
    //중복 제거된 Set의 크기가 가질 수 있는 폰켓몬의 개수보다 많으면 그 개수대로 return
    //그렇지 않으면 set의 크기 return
        int n = nums.length / 2;
        HashSet<Integer> pkmon = new HashSet<>();
        for(int num : nums){
            pkmon.add(num);
        }
        if(pkmon.size() >= n){
            return n;
        }
        else return pkmon.size();
    }
}
