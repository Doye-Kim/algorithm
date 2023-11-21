// https://school.programmers.co.kr/learn/courses/30/lessons/86491
// Solution.java

class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxX = maxX > sizes[i][0] ? maxX : sizes[i][0];
            maxY = maxY > sizes[i][1] ? maxY : sizes[i][1];
        }
        int answer = maxX * maxY;
        return answer;
    }
}
