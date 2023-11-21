// D4
// 1861. 정사각형의 방


import java.util.*;
class Solution
{
    static int n;
    static int[][] rooms;
    static int max;
    static int maxroom;
    static boolean[][] isVisited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            rooms = new int[n][n];
            isVisited = new boolean[n][n];
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	rooms[i][j] = sc.nextInt();
                }  
            }
            max = 0;
            maxroom = -1;
            for(int x = 0; x < n; x++) {
            	for(int y = 0; y < n; y++) {
            		//System.out.println(rooms[x][y]);
            		isVisited[x][y] = true;
            		dfs(rooms[x][y], x, y, 1);
            		isVisited[x][y] = false;
            	}
            }
      System.out.println("#" + test_case + " " + maxroom + " " + max);
		}
	}
	static void dfs(int start, int x, int y, int cnt) {
		//System.out.println("dfs " + x + " " + y + " " + cnt );
		int now = rooms[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && isVisited[nx][ny] == false && (now + 1 == rooms[nx][ny])) {
				isVisited[nx][ny] = true;
				dfs(start, nx, ny, cnt + 1);
				isVisited[nx][ny] = false;
			}
		}
		if(max == cnt) {
			maxroom = start > maxroom ? maxroom : start;
		}
		if(max < cnt) {
			max = cnt;
			maxroom = start;
		}
		
	}
}
