import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		static int n;
		static int[][] map;
		static int[][][] memoi; // 한 좌표로 이동하는 모든 방법
		// 좌표 4, 3
		// [0][4][3] => 대각선으로 (4, 3)으로 이동하는 모든 경우의 수
		// [1] ... => 가로
		// [2] ... => 세로
		public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			map = new int[n+1][n+1];
			memoi = new int[3][n+1][n+1];
			for(int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			memoi[1][1][2] = 1; // 가로로 시작하는 (1, 2)
			for(int y = 1; y <= n; y++) {
				for (int x = 2; x <= n; x++) {
					// * X
					// X X
					
					// 대각선
					if(y < n && x < n && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0) {
						memoi[0][y+1][x+1] += (memoi[0][y][x] + memoi[1][y][x] + memoi[2][y][x]);
					}
					// 가로
					if(x < n && map[y][x+1] == 0) {
						memoi[1][y][x+1] += (memoi[0][y][x] + memoi[1][y][x]); // 세로 -> 가로의 경우는 X
					}
					// 세로
					if(y < n && map[y+1][x] == 0) {
						memoi[2][y+1][x] += (memoi[0][y][x] + memoi[2][y][x]);  // 가로 -> 세로의 경우는 X
					}
				}
			}
			System.out.println(memoi[0][n][n] + memoi[1][n][n] + memoi[2][n][n]);
		}
	}
