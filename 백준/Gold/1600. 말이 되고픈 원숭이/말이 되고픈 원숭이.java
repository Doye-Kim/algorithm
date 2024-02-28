import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int k, w, h, min;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dkx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dky = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visit = new boolean[h][w][k+1];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	static class Pos{
		int x, y, depth, jump;

		public Pos(int x, int y, int depth, int jump) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.jump = jump;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", depth=" + depth + ", k=" + jump + "]";
		}
	}
	static void bfs() {
		Deque<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(0, 0, 0, k));
		visit[0][0][k] = true;
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.x == h-1 && now.y == w-1) {
				min = Math.min(now.depth, min);
				break;
			}
			if(now.jump > 0) {
				// k점프
				for(int d = 0; d < 8; d++) {
					int nx = now.x + dkx[d];
					int ny = now.y + dky[d];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w || visit[nx][ny][now.jump - 1] || map[nx][ny] == 1) continue;
					q.offer(new Pos(nx, ny, now.depth + 1, now.jump-1));
					visit[nx][ny][now.jump-1] = true;
					
				}
			}
				for(int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w || visit[nx][ny][now.jump] || map[nx][ny] == 1) continue;
					q.offer(new Pos(nx, ny, now.depth + 1, now.jump));
					visit[nx][ny][now.jump] = true;
				}
		}
	}
}