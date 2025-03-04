import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, min;
	static boolean[][] visit;
	static ArrayList<Node> fire = new ArrayList<>();
	static Node start;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				char c = s.charAt(j);
				if(c == 'J') {
					map[i][j] = 0;
					start = new Node(i, j, 1);
				}
				else if(c == 'F') {
					map[i][j] = 1;
					fire.add(new Node(i, j, 1));
				}
				else if(c == '#') map[i][j] = -1;
				else map[i][j] = 0;
			}
		}
		if(fire != null) fire();
		//System.out.println(Arrays.deepToString(map));
		exit();
		System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
	}
	static void exit() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(start);
		visit[start.y][start.x] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			//System.out.println(q);
			//System.out.println(n);
			if(n.y == 0 || n.x == 0 || n.x == C-1 || n.y == R-1) {
				min = Math.min(min, n.t);
				return;
			}
			boolean flag = false;
			for(int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				if(nx < 0 || ny < 0 || nx >= C || ny >= R || visit[ny][nx] || map[ny][nx] == -1 || map[ny][nx] == 1 || (map[ny][nx] != 0 && map[ny][nx] <= (n.t + 1))) continue;
				visit[ny][nx] = true;
				//System.out.println(ny + " " + nx + " : " + map[ny][nx] + " " + (n.t + 1));
				q.offer(new Node(ny, nx, n.t + 1));
				flag = true;
			}
			if(!flag) continue;
		}
	}
	static void fire() {
		Queue<Node> q = new ArrayDeque<>();
		q.addAll(fire);
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int d = 0; d < 4; d++) {
				int ny = n.y + dy[d];
				int nx = n.x + dx[d];
				if(nx < 0 || ny < 0 || nx >= C || ny >= R || map[ny][nx] >= 1 || map[ny][nx] == -1) continue;
				map[ny][nx] = n.t + 1;
				q.offer(new Node(ny, nx, n.t + 1));
			}
		}
	}

	static class Node{
		int y, x, t;

		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", t=" + t + "]";
		}

	}
}