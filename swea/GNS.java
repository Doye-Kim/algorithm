// D3
// 1221. [S/W 문제해결 기본] 5일차 - GNS

import java.util.Scanner;
import java.util.HashMap;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

		for(int test_case = 1; test_case <= T; test_case++){
            String Tnum = sc.next();
            int x = sc.nextInt();
			HashMap<String, Integer> countNum = new HashMap<>();
            
            // 개수 세기 
            for(int i = 0; i < x; i++) {
            	String tmp = sc.next();
            	countNum.put(tmp, countNum.getOrDefault(tmp, 0) + 1);
            }
            // 출력
            System.out.println(Tnum);;
            for(int i = 0; i < num.length; i++) {
            	for(int j = 0; j < countNum.get(num[i]); j++) {
            		System.out.print(num[i] + " ");
            	}
            }
		}
	}
}
