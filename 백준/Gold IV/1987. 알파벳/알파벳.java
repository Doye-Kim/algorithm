import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] board;
	static int r, c;
	static int max;
	static Set<Character> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		for(int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		//System.out.println(set);
		System.out.println(max);
	}
	static void dfs(int x, int y, int cnt) {
		//System.out.println(x + " " + y);
		if(cnt > max) max = cnt;
		set.add(board[x][y]);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= r || ny >= c || set.contains(board[nx][ny])) continue;
			dfs(nx, ny, cnt + 1);
			set.remove(board[nx][ny]);
		}
		
	}
}