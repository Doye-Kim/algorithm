import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int max, n, cnt, resX, resY;
	static int[][] rooms;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			rooms = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					cnt = 1;
					bfs(i, j);
					if(max < cnt) {
						max = cnt;
						resX = i;
						resY = j;
					}
					if(max == cnt) {
						if(rooms[resX][resY] > rooms[i][j]) {
							resX = i;
							resY = j;
						}
					}
				}
			}
			sb.append(rooms[resX][resY]).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(rooms[node.x][node.y] + 1 == rooms[nx][ny]) {
					q.offer(new Node(nx, ny));
					cnt++;
				}
			}	
		}
	}
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
