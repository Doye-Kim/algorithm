// D2
// 1954. 달팽이 숫자

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우하좌상
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[][] snail = new int[N][N];

            System.out.println("#" + test_case);
            int x = 0; 
            int y = 0;   	
            int nd = 0; //현재 방향
            for(int i = 1; i <= N*N; i++) {
            	snail[x][y] = i;
            	if(x + dir[nd][0] >= N || x + dir[nd][0] < 0 || y + dir[nd][1] >= N || y + dir[nd][1] < 0 || snail[ x + dir[nd][0]][y + dir[nd][1]] != 0) {
            		nd = (nd + 1) % 4;
            	}
            	x = x + dir[nd][0];
            	y = y + dir[nd][1];
            }
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		System.out.print(snail[i][j] + " ");
                }
            	System.out.println();
            }
        }
	}
}
