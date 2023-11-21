// D3
// 2806. N-Queen

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static int answer;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] queen = new int[N];
            answer = 0;
            dfs(N, queen, 0);
            System.out.println("#" + test_case+ " " + answer);
		}
	}
    public static void dfs(int N, int[] queen, int row){
    	if(N == row) {
        	answer++;
            return;
        }
		for (int i = 0; i < N; i++) {
			boolean isPossible = true;
			for (int j = 0; j < row; j++) {
        if (i == queen[j] || i == queen[j]+(row - j) || i == queen[j]-(row - j)) {		//직선, 대각선 확인 
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				queen[cnt] = i;
				dfs(N, attack, cnt + 1);
			}
		}
    }
}
