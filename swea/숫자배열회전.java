import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] rc = new int[n][n];
            for(int  i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	rc[i][j] = sc.nextInt();
                }
            }
            int[][] turnRC1 = new int[n][n];
            int[][] turnRC2 = new int[n][n];
            int[][] turnRC3 = new int[n][n];
            
            for(int  i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	turnRC1[j][n - i - 1] = rc[i][j];
                    turnRC2[n - i - 1][n - j - 1] = rc[i][j];
                    turnRC3[n - j - 1][i] = rc[i][j];
                }
            }
            System.out.println("#" + test_case);
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                    System.out.print(turnRC1[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < n; j++){
                    System.out.print(turnRC2[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < n; j++){
                    System.out.print(turnRC3[i][j]);
                }
                System.out.println();
            }
		}
	}
}
