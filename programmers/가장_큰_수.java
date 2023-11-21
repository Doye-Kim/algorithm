// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// Solution.java

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        //[0, 0, 0]일 경우 000이 아니라 0을 출력하게 하도록 하기 위함
        if (arr[0].equals("0")) {
           return "0";
        }
	
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }


        return answer.toString();
    }
}
