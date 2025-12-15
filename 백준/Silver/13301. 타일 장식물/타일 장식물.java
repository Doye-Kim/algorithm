import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++){
		    dp[i] = dp[i - 1] + dp[i - 2];
		}
		long ans = dp[n] * 2 + dp[n - 1] * 2;
		System.out.print(ans);
	}
}
