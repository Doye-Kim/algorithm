// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// Solution.java

class Solution {
    int cnt, zeroCnt;
    
    public int[] solution(String s) {
        toOne(s);
        int[] answer = {cnt, zeroCnt};
        return answer;
    }
    
    public void toOne(String s){
        String replace = s.replace(String.valueOf('0'), "");
        zeroCnt += s.length() - replace.length();
        cnt++;
        s = Integer.toBinaryString(replace.length());
        if(replace.equals("1")) return;
        toOne(s);
    }
}
