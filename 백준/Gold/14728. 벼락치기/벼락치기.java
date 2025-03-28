import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] bags = new int[n + 1][2];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[t + 1];
        for(int i = 1; i <= n; i++){
            for(int j = t; j >= bags[i][0]; j--){
                dp[j] = Math.max(dp[j], dp[j - bags[i][0]] + bags[i][1]);
            }
        }
        System.out.println(dp[t]);
	}
}