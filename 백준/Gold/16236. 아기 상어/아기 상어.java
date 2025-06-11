import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, size, by, bx, ans = 0, INF= Integer.MAX_VALUE;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					by = i;
					bx = j;
					map[i][j] = 0;
				}
			}
		}
		size = 2;
		int dist = 0;
		int cnt = size;
		int my = 0, mx = 0;
		while(true) {
			if(cnt == 0) {
				size++;
				cnt = size;
			}
			int min = INF;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] < size && map[i][j] > 0) {
						dist = bfs(i, j);
						if(min > dist) {
							my = i;
							mx = j;
							min = dist;
						}
					}
				}
			}
			if(min != INF) {
				map[my][mx] = 0;
				by = my;
				bx = mx;
				ans += min;
				cnt--;
			}
			else break;
		}
		System.out.println(ans);
	}
	static int bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][N];
		q.offer(new Node(by, bx, 0));
		visit[by][bx] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.y == y && node.x == x) {
				return node.cnt;
			}
			for(int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > size) continue;
				visit[ny][nx] = true;
				q.offer(new Node(ny, nx, node.cnt+1));
			}
		}
		return INF;
	}
	static class Node{
		int y, x, cnt;

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}	
	}
}
