//https://school.programmers.co.kr/learn/courses/30/lessons/12930
// Solution.java

class Solution {
    public String solution(String s) {
        char[] sArr = s.toCharArray();
        int isOE = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(sArr[i] == ' '){
                isOE = 0;
            }
            else{
                if(isOE % 2 == 0){
                    sArr[i] = Character.toUpperCase(sArr[i]);
                }
                else{
                    sArr[i] = Character.toLowerCase(sArr[i]);
                }
                isOE++;
            }
        }
        String answer = new String(sArr);
        return answer;
    }
}
