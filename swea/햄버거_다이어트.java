// D3
// 5215. 햄버거 다이어트

import java.util.Scanner;

class Solution
{
	static int[] score;
	static int[] kcal;
	static boolean[] isVisited;
	static int n;
	static int l;
	static int max;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			l = sc.nextInt();
			score = new int[n];
			kcal = new int[n];
			isVisited = new boolean[n];
			for(int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}

			max = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test_case + " " + max);
		}
	}
	static void dfs(int cur, int kSum, int sSum) {
		boolean isEnd = true;
		//순서대로 방문하기 때문에 선택된 재료보다 앞에 있는 건 고려하지 않는다
		for(int i = cur; i < n; i++) {
			if(isVisited[i] == false && kSum + kcal[i] <= l) {
				isVisited[i] = true;
				isEnd = false;
				dfs(i, kSum + kcal[i], sSum + score[i]);
				isVisited[i] = false;
			}
		}
        // 더이상 방문할 게 없으면 총 점수와 max를 비교해 계산함
		if(isEnd == true) {
			if(sSum > max) {
				max = sSum;
				return;
			}
		}
	}
}
