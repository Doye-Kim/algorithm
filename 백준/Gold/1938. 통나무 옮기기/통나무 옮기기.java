import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int N, nd; // nd: 가로 1, 세로 0
	static char[][] map;
	static boolean ans = false;
	static boolean[][][] visit;
	static Node[] b, e;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N][2];
		b = new Node[3];
		e = new Node[3];
		int bidx = 0, eidx = 0;;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') b[bidx++] = new Node(i, j, 0, 0);
				else if(map[i][j] == 'E') e[eidx++] = new Node(i, j, 0, 0);
			}
		}
		if(b[0].x - b[1].x == 0) {
			b[1].d = 0;
		
		}
		else {
			b[1].d = 1;
		}
		if(e[0].x - e[1].x == 0) {
			e[1].d = 0;
		}
		else {
			e[1].d = 1;
		}
		bfs();
		if(!ans) System.out.println(0);
	}
	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(b[1]);
		visit[b[1].y][b[1].x][b[1].d] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.d == 0) { // 세로
				b[0].y = node.y-1;
				b[1].y = node.y;
				b[2].y = node.y+1;
				b[0].x = node.x;
				b[1].x = node.x;
				b[2].x = node.x;
				if(node.d == e[1].d && node.y == e[1].y && node.x == e[1].x) {
					ans = true;
					System.out.println(node.cnt);
					return;
				}
				for(int d = 0; d < 4; d++) {
					boolean flag = true;
					int vc = 0;
					for(int i = 0; i < 3; i++) {
						int ny = b[i].y + dy[d];
						int nx = b[i].x + dx[d];
						if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == '1' || (i == 1 && visit[ny][nx][0])) flag = false;
					}
					if(flag) {
						visit[node.y + dy[d]][node.x + dx[d]][node.d] = true;
						q.offer(new Node(node.y + dy[d], node.x + dx[d], node.d, node.cnt+1));
					}
				}
				boolean flag = true;

				for(int i = node.y-1; i <= node.y+1; i++) {
					for(int j = node.x-1; j <= node.x+1; j++) {
						if(i < 0 || j < 0 || i >= N || j >= N || map[i][j] == '1' || (i == node.y && j == node.x && visit[i][j][1])) flag = false;
					}
				}
				if(flag) {
					visit[node.y][node.x][1] = true;
					q.offer(new Node(node.y, node.x, 1, node.cnt + 1));
				}
			}
			else {
				b[0].y = node.y;
				b[1].y = node.y;
				b[2].y = node.y;
				b[0].x = node.x-1;
				b[1].x = node.x;
				b[2].x = node.x+1;
				if(node.d == e[1].d && node.y == e[1].y && node.x == e[1].x) {
					ans = true;
					System.out.println(node.cnt);
					return;
				}
				for(int d = 0; d < 4; d++) {
					boolean flag = true;
					for(int i = 0; i < 3; i++) {
						int ny = b[i].y + dy[d];
						int nx = b[i].x + dx[d];
						if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == '1' || ((i == 1 && visit[ny][nx][1]))) flag = false;
					}
					if(flag) {
						visit[node.y + dy[d]][node.x + dx[d]][node.d] = true;
						q.offer(new Node(node.y + dy[d], node.x + dx[d], node.d, node.cnt+1));
					}
				}
				boolean flag = true;
				for(int i = node.y-1; i <= node.y+1; i++) {
					for(int j = node.x-1; j <= node.x+1; j++) {
						if(i < 0 || j < 0 || i >= N || j >= N || map[i][j] == '1' || (j == node.x && i == node.y && visit[i][j][0])) flag = false;
					}
				}
				if(flag) {
					visit[node.y][node.x][0] = true;
					q.offer(new Node(node.y, node.x, 0, node.cnt + 1));
				}
			}
		}
	}

	static class Node{
		int y, x, d, cnt;

		public Node(int y, int x, int d, int cnt) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.cnt = cnt;
		}
	}
}