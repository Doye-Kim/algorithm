// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// Solution.java

import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++){
            //정렬하면 다음 것만 보고 리턴 해도 됨
            if(phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
