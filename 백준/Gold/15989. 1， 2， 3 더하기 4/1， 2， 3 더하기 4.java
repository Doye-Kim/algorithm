import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        StringBuilder sb = new StringBuilder();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            for(int i = 4; i <= n; i++){
                dp[i] = dp[i - 3] + (i / 2) + 1;
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}
