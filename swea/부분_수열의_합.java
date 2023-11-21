// D3
// 2817. 부분 수열의 합


import java.util.*;

class Solution
{
	static int[] num;
	static int cnt;
	static int k;
	static int n;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			num = new int[n];
			for(int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			cnt = 0;
			cal(0, 0);
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
	static void cal(int curr, int sum) {
		//System.out.println(curr + "  " + sum);
		if(sum == k) {
			cnt++; 
			return;
		}
        
		if(curr >= n) return;
        
		cal(curr + 1, sum + num[curr]); //부분 집합에 포함하는 경우
		cal(curr + 1, sum); // 부분 집합에 포함하지 않는 경우
		
	}
}
