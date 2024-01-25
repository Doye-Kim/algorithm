import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static int n;
	static int[][] black;
	static int[] dirX = {1, -1, 0, 0};
	static int[] dirY = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = 1;
		String line = null;
		while(!(line = br.readLine()).equals("0")) {
			n = Integer.parseInt(line);
			black = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					black[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if(n != 0) {
				int answer = bfs();
				System.out.println("Problem " + test_case + ": " + answer);
				test_case++;
			}
		}
		//System.out.println(sb.toString());
	}
	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][] sum = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(sum[i], Integer.MAX_VALUE);
		}
		
		pq.add(new Node(0, 0, black[0][0]));
		sum[0][0] = black[0][0];
		
		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int cx = pos.x, cy = pos.y, cc = pos.cost;
			
			if(cx == n - 1 &&  cy == n - 1) return cc;
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dirX[i];
				int ny = cy + dirY[i];
				
				if(nx < 0 || ny < 0 || nx == n || ny == n || sum[nx][ny] > sum[n-1][n-1]) continue;
				
				if(sum[nx][ny] > cc + black[nx][ny]) {
					sum[nx][ny] = cc + black[nx][ny];
					pq.add(new Node(nx, ny, cc + black[nx][ny]));
				}
			}
		}
		return 0;
	}
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
