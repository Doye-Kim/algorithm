// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// Solution.java

import java.util.Stack;

class Solution {
    boolean solution(String s) {  
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
        // '('일 때 push, ')'일 때 pop
        // 이때, '('없이 ')'가 먼저 나온 경우 return false;
            if(s.charAt(i) == '('){
                stack.push("(");
            }
            else{
                if(stack.empty()) return false;
                else stack.pop();
            }
        }
        // '()'의 순서와 개수가 맞아 떨어져 스택이 비어있으면 true, 아니면 false
        return stack.empty();
    }
}
