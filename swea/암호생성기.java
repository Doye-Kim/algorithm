// D3
// 1225. [S/W 문제해결 기본] 7일차 - 암호생성기

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
			int Tnum = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < 8; i++){
            	queue.add(sc.nextInt());	
            }
            int value = 1;
            while(value != 0) {
            	for(int i = 1; i < 6; i++) {
            		value = queue.poll();
            		value -= i;
            		if(value <= 0) value = 0;
            		queue.add(value);
            		if(value == 0) break;
            	}
            }
            System.out.print("#" + Tnum);
            for(int i = 0; i < 8; i++){
            	System.out.print(" " + queue.poll());
            } 
            System.out.println("");
		}
	}
}
