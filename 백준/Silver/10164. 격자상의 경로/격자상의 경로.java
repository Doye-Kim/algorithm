import java.util.*;
import java.io.*;
public class Main
{
    static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		dp = new int[n][m];
		int toCircle = 1;
		int ey = 0; 
		int ex = 0;
		
		if(k != 0){
		    ey = k / m;
		    ex = k % m - 1;
		    toCircle = calcCnt(0, 0, ey, ex);
		}
		int toEnd = calcCnt(ey, ex, n - 1, m - 1);
		System.out.print(toCircle * toEnd);
	}
	
	static int calcCnt(int sy, int sx, int ey, int ex){
	    for(int i = sy; i <= ey; i++){
		    dp[i][sx] = 1;
		}
		for(int i = sx; i <= ex; i++){
		    dp[sy][i] = 1;
		}
		
		for(int i = sy + 1; i <= ey; i++){
		    for(int j = sx + 1; j <= ex; j++){
		        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		    }
		}
		return dp[ey][ex];
	}
}
