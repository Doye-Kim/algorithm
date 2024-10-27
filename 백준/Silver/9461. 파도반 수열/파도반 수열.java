import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 4; i < 101; i++){
		    dp[i] = dp[i-2] + dp[i-3];
		}
		for(int t = 0; t < T; t++){
		    int n = Integer.parseInt(br.readLine());
		    System.out.println(dp[n]);
		}
	}
}
