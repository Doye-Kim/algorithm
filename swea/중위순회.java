// D4
// 1231. [S/W 문제해결 기본] 9일차 - 중위순회

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static String tree[];
    
	//중위 순회
	public static void inOrder(int cur, int n) {
		if (cur > n) return;
		inOrder(cur * 2, n); 
		System.out.print(tree[cur]); 
		inOrder(cur * 2 + 1, n); 
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			sc.nextLine();
            // 트리의 index가 1부터 시작하기 때문에 n+1 해줌
			tree = new String[n + 1];

			for (int i = 1; i <= n; i++) {
				String stl = sc.nextLine();
                String[] st = stl.split(" ");
                // index에 따라 data 저장
				int index = Integer.parseInt(st[0]);
				tree[index] = st[1];
			}
			
			System.out.print("#" + test_case + " ");
			inOrder(1, n);
			System.out.println();
		}
	}
}
