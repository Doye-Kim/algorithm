// https://school.programmers.co.kr/learn/courses/30/lessons/42748
// Solution.java

import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //배열 자르기
        for(int i = 0; i < commands.length; i++){
            int[] destArray = new int[commands[i][1] - commands[i][0] + 1];
            int x = 0;
            for(int j = commands[i][0] - 1; j < commands[i][0] + destArray.length - 1; j++){
                destArray[x] = array[j];
                x++;
            }
            sort(destArray, 0, destArray.length - 1);
            answer[i] = destArray[commands[i][2] - 1];
        }
        return answer;
    }
    //퀵 정렬
    public void sort(int[] array, int l, int r){
        int pivot = (l + r) / 2;
        int[] res = {};
        int tmp;
        int left = l;
        int right = r;
        do{
            while(array[left] < array[pivot])   left++;
            while(array[right] > array[pivot])  right--;
            
            if(left <= right){
                tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
                
                left++;
                right--;
            }
        }while (left<= right);
        
        if(left < r) sort(array, left, r);
        if(right > l) sort(array, l, right);
    }
}
