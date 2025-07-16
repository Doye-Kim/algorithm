import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] volumns = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++){
		    volumns[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n + 1][m + 1];
		dp[0][s] = 1;
		int ans = 0;
		for(int i = 1; i <= n; i++){
		    boolean flag = false;
		    for(int j = 0; j <= m; j++){
		        if(dp[i - 1][j] == 1){
		            int v1 = j + volumns[i];
		            int v2 = j - volumns[i];
		            if(v1 <= m) {
		                dp[i][v1] = 1;
		                flag = true;
		            }
		            if(v2 >= 0) {
		                dp[i][v2] = 1;
		                flag = true;
		            }
		        }
		    }
		    if(!flag) {
		        ans = -1;
		        break;
		    }
		}
	    if(ans != -1){
	        for(int i = m; i >= 0; i--){
	            if(dp[n][i] == 1){
	                ans = i;
	                break;
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
