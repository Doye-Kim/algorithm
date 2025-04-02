import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] child = new int[n];
		int[] dp = new int[n + 1];
		for(int i = 0; i < n; i++){
		    child[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		for(int i = 0; i < n; i++){
		    dp[i] = 1;
		    for(int j = 0; j < i; j++){
		        if(child[j] < child[i] && dp[j] + 1 > dp[i]){
		            dp[i] = dp[j] + 1;
		            max = Math.max(max, dp[i]);
		        }
		    }
		}
		System.out.println(n - max);
	}

}
