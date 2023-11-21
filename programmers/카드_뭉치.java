// https://school.programmers.co.kr/learn/courses/30/lessons/159994
// Solution.java
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        //사용 조건에 따라 사용함을 확인하기 위한 변수
        int cd1use, cd2use;
        cd1use = cd2use = 0;
        
        for(String s: goal){
            if(cd1use != cards1.length && s.equals(cards1[cd1use])){
                cd1use++;
            }
            else if(cd2use != cards2.length && s.equals(cards2[cd2use])){
                cd2use++;
            }
            else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
