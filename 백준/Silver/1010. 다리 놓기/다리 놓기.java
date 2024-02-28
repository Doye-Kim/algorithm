import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static int T, n, r;
	static BigInteger[] dp = new BigInteger[31];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp[0] = BigInteger.valueOf(1);
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= n; i++) {
				dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
			}
			sb.append((dp[n].divide(dp[r].multiply(dp[n-r])))).append("\n");
		}
		System.out.println(sb);
	}

}