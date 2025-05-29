import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[n + 1];
		int max = -1000;
		for(int i = 1; i <= n; i++){
		    int now = Integer.parseInt(st.nextToken());
		    dp[i] = Math.max(now, dp[i - 1] + now);
		    max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
}
