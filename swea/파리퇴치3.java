import java.util.*;

class Solution
{
   	static int[] dirX1 = {0, 0, -1, 1}; 
   	static int[] dirY1 = {-1, 1, 0, 0};
    static int[] dirX2 = {1, 1, -1, -1};
    static int[] dirY2 = {-1, 1, -1, 1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] flys= new int[n][n];

            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	flys[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                  int res = calc(flys, i, j, m, n);
                	max = max > res ? max : res;
                }
            }
            System.out.println("#" + test_case + " " + max);
		}
	}
    static int calc(int[][] flys, int x, int y, int m, int n){
        int sum1 = flys[x][y], sum2 = flys[x][y];
        for(int j = 0; j < 4; j++){
        	for(int i = 1; i < m; i++){
                int nx = x + dirX1[j]*i;
                int ny = y + dirY1[j]*i;
            	if(nx >= 0 && ny >= 0 && nx < n && ny < n)  sum1 += flys[nx][ny];
                int nx2 = x + dirX2[j]*i;
                int ny2 = y + dirY2[j]*i;
            	if(nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < n) sum2 += flys[nx2][ny2];
            }
        }
        return sum1 > sum2 ? sum1 : sum2;
    }
}
