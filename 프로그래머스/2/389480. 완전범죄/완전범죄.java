import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int size = info.length;
        int INF = 121;
        int[][] dp = new int[size + 1][m];
        for(int i = 0; i <= size; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        // dp[i][j] = k
        // => i개의 물건을 훔쳤을 때 b의 흔적 개수 j, a의 흔적 개수 k
        for(int i = 1; i <= size; i++){
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for(int j = 0; j < m; j++){
                // a가 훔친 경우, b의 흔적 개수엔 변화가 없다
                dp[i][j] = Math.min(dp[i - 1][j] + a, dp[i][j]);
                
                // b가 훔친 경우, a의 흔적 개수엔 변화가 없다
                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i - 1][j], dp[i][j + b]);
                }
            }
        }
        int min = INF;
        for(int j = 0; j < m; j++){
            min = Math.min(dp[size][j], min);
        }
        
        return min < n ? min : -1;
    }
}