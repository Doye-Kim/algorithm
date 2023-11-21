// https://school.programmers.co.kr/learn/courses/30/lessons/42895
// Solution.java

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        String tmp = "";
        
        //5, 55, 555 이런 것들 기본 세팅
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
            if(i >= 1){
                tmp += N;
                dp.get(i).add(Integer.parseInt(tmp));    
            }
        }
        dp.get(0).add(0);
        
        for(int i=2; i<9; i++){
            for(int j = 1; j <= i; j++){
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i - j);

                for(int preNum : preSet){
                    for(int postNum : postSet){
                        dp.get(i).add(preNum + postNum);
                        dp.get(i).add(preNum - postNum);
                        dp.get(i).add(preNum * postNum);

                        if(preNum != 0 && postNum != 0)
                            dp.get(i).add(preNum / postNum);
                    }
                }
            }
        }
        for(Set<Integer> sub : dp){
            if(sub.contains(number)) return dp.indexOf(sub);
        }
        
        return -1;
    }
}
