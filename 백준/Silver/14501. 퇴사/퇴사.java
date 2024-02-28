import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static Con[] con;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		con = new Con[n+1];
		con[0] = new Con(0,0,0);
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			con[i] = new Con(i, Integer.parseInt(st.nextToken()) + i - 1, Integer.parseInt(st.nextToken()));
//			if(i + con[i].end > n+1) continue;
		}
		Arrays.sort(con);
//		System.out.println(Arrays.toString(con));
		int ans = 0;
		dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			int e = con[i].end;
//			int s = con[i].start;
			if(e > n) break;
			boolean flag = false;
			int now = 0;
			for(int j = con[i].start - 1; j > 0; j--) {
				if(dp[j] > now) {
					now = dp[j];
					flag = true;
				}
			}
			if(!flag) dp[e] = Math.max(dp[e], con[i].cost);
			else dp[e] = Math.max(dp[e], now + con[i].cost);
		}
		for(int i = n; i > 0; i--) {
			if(dp[i] > ans) ans = dp[i];
		}
		System.out.println(ans);
	}

	static class Con implements Comparable<Con>{
		int start, end, cost;

		public Con(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Con [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Con o) {
			return end == o.end ? o.cost - cost : end - o.end;
		}
		
	}
}