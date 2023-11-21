// 1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱
// D3

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int Tnum = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int answer = power(n, m);
            System.out.println("#" + Tnum + " " + answer);
		}
	}
    static int power(int n, int m){
        if(m == 1) return n;
        return n*power(n, m-1);
    }
}
