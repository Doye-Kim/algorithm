import java.util.*;
import java.io.*;

public class Main
{
    static int n, k, ans;
    static int[][] ana;
    static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ana = new int[n][n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < n; j++){
		        ana[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int sum = 0;
		for(int x = 0; x < n; x++){
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            ana[i][j] = Math.min(ana[i][j], ana[i][x] + ana[x][j]);
		        }
		    }
		}
		ans = Integer.MAX_VALUE;
		visit[k] = true;
		dfs(0, k, 0);
		System.out.println(ans);
	}
	static void dfs(int level, int start, int sum){
	    if(level == n - 1){
	        ans = Math.min(ans, sum);
	        return;
	    }
	    for(int i = 0; i < n; i++){
	        if(!visit[i]){
	            visit[i] = true;
	            dfs(level + 1, i, sum + ana[start][i]);
	            visit[i] = false;
	        }
	    }
	}
}
