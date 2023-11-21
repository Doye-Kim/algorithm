// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// Solution

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            return s.matches("^[0-9]*$");
        }
        else return false;
    }
}
