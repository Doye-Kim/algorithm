// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// Solution.java

import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    String[] part;
    boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        part = numbers.split("");
        visited = new boolean[part.length];
        combi("");
        Iterator iter = set.iterator();	
        while(iter.hasNext()) {
            if(isPrime((Integer)iter.next()) == true){
                answer++;
            }
        }
        return answer;
    }
    //dfs
    public void combi(String sum){
        if(!sum.isEmpty()){
            set.add(Integer.parseInt(sum));
        }
        for(int i = 0; i < part.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(sum += part[i]);
                visited[i] = false;
                //어차피 끝까지 돌고 맨 끝부터 false가 되는 거라 
                //맨 뒤부터 하나씩 삭제한다.
                //여기서 삭제를 하지 않으면 계속 더해져서 중복 조합함
                sum = sum.substring(0, sum.length()-1);
            }
        }
    }
    //소수 판별 함수
    public boolean isPrime(int number){
        if(number == 0 || number == 1) return false;
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
