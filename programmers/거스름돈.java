// https://school.programmers.co.kr/learn/courses/30/lessons/12907
// Solution.java

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        //혹시 몰라 sort 함
        Arrays.sort(money);
        
        int[][] dp = new int[money.length + 1][n + 1];

        for(int i = 1; i <= money.length; i++){
            for(int j = 0; j <= n; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }
                else if(j < money[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                // % 1000000007 하는 이유는 제한사항 참고
                else dp[i][j] = dp[i - 1][j] + dp[i][j - money[i - 1]] % 1000000007;
            }
        }
        return dp[money.length][n];
    }
}
