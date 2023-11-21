// D4
// 2819. 격자판의 숫자 이어 붙이기

import java.util.*;
import java.io.FileInputStream;

class Solution
{
	static Set<String> set;
	static String[][] rc;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우 
	static int N = 4;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			rc = new String[N][N];
			set = new HashSet<>();
			for(int i = 0; i < N; i++) {
				rc[i] = sc.nextLine().split(" ");
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					move(0, i, j, "");
				}
			}
			System.out.printf("#%d %d\n", test_case, set.size());
		}
	}
	static void move(int cnt, int x, int y, String cur) {
		if(cnt == 7) {
			set.add(cur);
			return;
		}
		for(int i = 0; i < N; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			String ns = cur + rc[nx][ny];
			move(cnt + 1, nx, ny, ns);
		}
	}
}
