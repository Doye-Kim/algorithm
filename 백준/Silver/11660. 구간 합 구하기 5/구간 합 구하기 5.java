import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] board;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				//int now = Integer.parseInt(st.nextToken());
				board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + Integer.parseInt(st.nextToken());
				//System.out.println(now);
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				sb.append(board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1]).append("\n");
			
		}
		System.out.println(sb);
	}

}