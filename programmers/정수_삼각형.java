// https://school.programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    public int solution(int[][] triangle) {
        int l = triangle.length;
      
        int[][] dp = new int[l][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];

        // 맨 왼쪽, 맨 오른쪽, 사이로 구분
        for(int i = 1; i < l; i++){
            dp[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++){
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if(j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        int answer = 0;
        // 마지막 리프 노드들 중 최댓값 출력
        for(int i : dp[l - 1]){
            answer = Math.max(i, answer);
        }

        return answer;
    }
}
