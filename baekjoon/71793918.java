//응용 bfs?

import java.util.*;
import java.io.*;

class Main
{
    static int[][] donut;
    static int n, m;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static boolean[][] isVisited;
    
	public static void main(String args[]) throws Exception
	{
    //input
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = bf.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		donut = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] tmp = bf.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				donut[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		int ans = 0;
		//System.out.println(Arrays.toString(donut[4]));

    // 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!isVisited[i][j] && donut[i][j] == 0) {
					ans++;
					bfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}
	static void bfs(int x, int y) {
		//System.out.println("bfs" + x + " " + y);
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int cx = p[0];
			int cy = p[1];
			for(int i = 0; i < 4; i++) {
				int nx = cx + dirX[i];
				int ny = cy + dirY[i];
				
				if(nx < 0) nx = n - 1;
				if(nx == n) nx = 0;
				if(ny < 0) ny = m - 1;
				if(ny == m) ny = 0;
				
				if(!isVisited[nx][ny] && donut[nx][ny] == 0) {
					//System.out.println(nx + " " + ny);
					isVisited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
