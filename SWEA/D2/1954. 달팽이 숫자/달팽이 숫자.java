import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[] dirX = {0, 1, 0, -1}; // 우하좌상
        int[] dirY = {1, 0, -1, 0};
		
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append("\n");
			int n = sc.nextInt();
            int[][] snail = new int[n][n];
            int nd = 0;
            int x = 0;
            int y = 0;
            for(int i = 1; i <= n*n; i++) {
            	snail[x][y] = i;
            	int nx = x + dirX[nd];
            	int ny = y + dirY[nd];
            	if(nx < 0 || ny < 0 || nx >= n || ny >= n || snail[nx][ny] != 0) {
            		nd++;
            		if(nd == 4) nd = 0;
            	}
            	x = x + dirX[nd];
            	y = y + dirY[nd];
            }
            for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		sb.append(snail[i][j] + " ");
            	}
            	sb.append("\n");
            }
		}
		System.out.println(sb);
	}
}