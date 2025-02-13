import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int[] dx = {0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(triangle[i], -1);
            for(int j = 0; j < i + 1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = triangle[i][j];
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Math.max(dp[i-1][j], j == 0 ? 0 : dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(dp[n - 1][i], max);
        }
        System.out.println(max);
	}
}