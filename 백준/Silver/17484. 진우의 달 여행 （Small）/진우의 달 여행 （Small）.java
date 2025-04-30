import java.util.*;
import java.io.*;

public class Main
{
    static int INF = 3600;
    static int n, m;
    static int[][] map;
    static int[][][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    map = new int[n][m];
	    dp = new int[n][m][3];
	    for(int i = 0; i < n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j = 0; j < m; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	            Arrays.fill(dp[i][j], INF);
	        }
	    }
	    
	    for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = map[0][j];
            }
        }
        
	    for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 3; d++) {
                    int prevJ = j + (d == 0 ? 1 : d == 2 ? -1 : 0);
                    if (prevJ < 0 || prevJ >= m) continue;

                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (prevD == d) continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prevJ][prevD] + map[i][j]);
                    }
                }
            }
        }
	    int ans = INF;
	    for(int i = 0; i < m; i++){
	        for(int j = 0; j < 3; j++){
	            ans = Math.min(ans, dp[n - 1][i][j]);
	        }
	    }
	    System.out.println(ans);
	}
}
