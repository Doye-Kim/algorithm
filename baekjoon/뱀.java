import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n, k, l;
		int[][] board;
		int[][] apple; // 사과 위치
		int[] turnTime; // 회전 시간
		char[] turnDir; // 회전 방향
		
		// input
		n = Integer.parseInt(bf.readLine());
		board = new int[n][n];
		k = Integer.parseInt(bf.readLine());
		apple = new int[k][2];
		for(int i = 0; i < k; i++) {
			String[] a = bf.readLine().split(" ");
			apple[i][0] = Integer.parseInt(a[0]) - 1; // 주어지는 값들은 (0,0)이 아니라 (1, 1)에서 시작하기 때문에 ~~
			apple[i][1] = Integer.parseInt(a[1]) - 1;
		}
		l = Integer.parseInt(bf.readLine());
		turnTime = new int[l];
		turnDir = new char[l];
		for(int i = 0; i < l; i++) {
			String[] a = bf.readLine().split(" ");
			turnTime[i] = Integer.parseInt(a[0]);
			turnDir[i] = a[1].charAt(0);
		}
		
		// 구현 
		Queue<int[]> snake = new LinkedList<>();
		
		boolean isEnd = false;
		
		int[] dirX = {-1, 0, 1, 0};
		int[] dirY = {0, 1, 0, -1}; // 상우하좌  

		int ti = 0; //회전 인덱스 
		int nt = 1; // 지금 시간 
		int nd = 1; // 지금 방향 
		
		int cx = 0, cy = 0;
		snake.offer(new int[] {cx, cy});

		while(!isEnd) {
			boolean eatApple = false;
			
			int nx = cx + dirX[nd];
			int ny = cy + dirY[nd];
			if(nx == n || ny == n || nx < 0 || ny < 0 || board[nx][ny] == 1) {
				isEnd = true;
				break;
			}
			//몸 길이 늘려서 다음 칸으로 이동 처리, board가 1이면 뱀 
			else{
				snake.offer(new int[] {nx, ny});
				board[nx][ny] = 1;
				cx = nx;
				cy = ny;
			}

			//사과 있을 때, 없을 때 
			for(int i = 0; i < k; i++) {
				//사과 있을 때! 
				if(nx == apple[i][0] && ny == apple[i][1]) {
					apple[i][0] = -1;
					apple[i][1] = -1;
					eatApple = true;
					break;
				}
			}
			if(!eatApple) {
				int[] tmp = snake.poll();
				board[tmp[0]][tmp[1]] = 0;
			}		
			
			//회전 시 
			if(ti < l && nt == turnTime[ti]) {
				//System.out.println("회전합미다 ");
				if(turnDir[ti] == 'L') {
					nd--;
					if(nd == -1) nd = 3;
				}
				if(turnDir[ti] == 'D') {
					nd++;
					if(nd == 4) nd = 0;
					
				}
				ti++;
			}
			nt++;
		}
	System.out.println(nt);
	}
}
