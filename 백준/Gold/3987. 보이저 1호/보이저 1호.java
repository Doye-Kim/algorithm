import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, max, nd, s;
	static boolean isRepeat;
	static char[][] space;
	static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, 1, 0, -1};
	static char[] dir = {'U', 'R', 'D', 'L'};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		space = new char[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < m; j++) {
				space[i][j] = s.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		for(int i = 0; i < 4; i++) {
			count(x, y, i);
			if(isRepeat) break;
		}
		sb.append(dir[s]).append("\n");
		if(isRepeat) sb.append("Voyager");
		else sb.append(max);
		System.out.println(sb);
	}
	static void count(int x, int y, int sd) {
		int nx = x;
		int ny = y;
		int time = 1;
		nd = sd;

		while(true) {
			if(nd == -1) nd = 3;
			if(nd == 4) nd = 0;
			
			nx = nx + dirX[nd];
			ny = ny + dirY[nd];

			if(time > n*m*2) {
				isRepeat = true;
				s = sd;
				break;
			}
			if(nx < 0 || ny < 0 || nx >= n || ny >= m || space[nx][ny] == 'C') {
				if(time > max) {
					max = time;
					s = sd;
				}
				break;
			}
			if(space[nx][ny] == '/') {
				if(nd == 2 || nd == 0) nd++;
				else nd--;
			}
			if(space[nx][ny] == '\\') {
				if(nd == 1 || nd == 3) nd++;
				else nd--;
			}
			time++;
		}
	}
}