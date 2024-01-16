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
		boolean isEnd = false;
		
		int[] dirX = {-1, 1, 0, 0}; // UDLR 
		int[] dirY = {0, 0, -1, 1};
		
		char[] dir = {'U', 'D', 'L', 'R'};
		char[] dirL = {'L', 'R', 'D', 'U'}; //{2, 3, 1, 0}; // LRDU
		char[] dirR = {'R', 'L', 'U', 'D'}; //{3, 2, 0, 1}; //RLUD
		
		Queue<int[]> snake = new LinkedList<>();
		
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
		//System.out.println(Arrays.toString(dir));
		int ti = 0; //회전 인덱스 
		int nt = 1; // 지금 시간 
		char nd = 'R'; // 지금 방향 
		
		int cx = 0, cy = 0;
		snake.offer(new int[] {cx, cy});
		
		int index = 0;
		//System.out.println(board[0][1]);
		while(!isEnd) {
			//System.out.println("c: " + cx + " " + cy + " nt: " + nt);
			boolean eatApple = false;
			for(int i = 0; i < 4; i++) {
				if(dir[i] == nd) index = i;
			}
			//System.out.println(index);
			int nx = cx + dirX[index];
			int ny = cy + dirY[index];
			if(nx == n || ny == n || nx < 0 || ny < 0 || board[nx][ny] == 1) {
				//System.out.println(nx + " " + ny + " " + board[nx][ny]);
				isEnd = true;
				break;
			}
			//몸 길이 늘려서 다음 칸으로 이동 처리, board가 1이면 뱀~ 
			else{
				snake.offer(new int[] {nx, ny});
				board[nx][ny] = 1;
				cx = nx;
				cy = ny;
			}
			//System.out.println("board: " + cx + " " + cy +  " " +board[nx][ny]);
			//사과 있을 때, 없을 때 구분
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
					nd = dirL[index];
				}
				if(turnDir[ti] == 'D') {
					nd = dirR[index];
				}
				ti++;
			}
			nt++;
		}
	System.out.println(nt);
	}
}
