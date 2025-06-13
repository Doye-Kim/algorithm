import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[n + 1];
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++){
		    cards[i] = Integer.parseInt(st.nextToken());
		    dp[i] = cards[i];
		}
		for(int i = 1; i <= n; i++){
		    for(int j = 1; j < i; j++){
		        dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
		    }
		}
		System.out.println(dp[n]);
	}
}
