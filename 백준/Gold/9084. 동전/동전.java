import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] coins, dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[M+1];
			dp[0] = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= M; j++) {
					if(j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
				}
			}
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
	}

}