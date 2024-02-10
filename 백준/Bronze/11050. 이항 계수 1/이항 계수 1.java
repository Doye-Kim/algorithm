import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][k + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= k; j++) {
				if(j == 0 || i == 0 || j == i) dp[i][j] = 1;
				else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		System.out.println(dp[n][k]);
	}
}
