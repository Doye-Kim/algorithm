import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] board;
	static int r, c;
	static int max;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j) - 'A';
			}
		}
		visited = new boolean[26];
		visited[board[0][0]] = true;
		dfs(0, 0, 1);

		System.out.println(max);
	}
	static void dfs(int x, int y, int cnt) {
		if(cnt > max) max = cnt;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= r || ny >= c || visited[board[nx][ny]]) continue;
			visited[board[nx][ny]] = true;
			dfs(nx, ny, cnt + 1);
			visited[board[nx][ny]] = false;
		}
		
	}
}