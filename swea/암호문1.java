// D3
// 1228. [S/W 문제해결 기본] 8일차 - 암호문1 D3

import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            ArrayList<Integer> password = new ArrayList<>();
            for(int i = 0; i < n; i++){
            	password.add(sc.nextInt());
            }
            int m = sc.nextInt();
            for(int i = 0; i < m; i++){
            	sc.next();
                int index = sc.nextInt();
                int x = sc.nextInt();
                ArrayList<Integer> insertNum = new ArrayList<>();
                for(int j = 0; j < x; j++){
                	insertNum.add(sc.nextInt());
                }   
                password.addAll(index, insertNum);
            }
            System.out.print("#" + test_case);
            for(int i = 0; i < 10; i++){
            	System.out.print(" " + password.get(i));
            }
            System.out.println("");
		}
	}
}
