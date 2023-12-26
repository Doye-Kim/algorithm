//https://swexpertacademy.com/main/code/problem/problemSolver.do
//D2

import java.util.*;

class Solution
{
    static int max, t, d;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            
            t = n > m ? n : m;
            d = n > m ? m : n;
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; i++){
            	a[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++){
            	b[i] = sc.nextInt();
            }
            max = 0;
            if(t == n) calc(b, a);
            else calc(a, b);
            System.out.println("#" + test_case + " " + max);
		}
	}
    public static void calc(int[] a, int[] b){
        for(int i = 0; i <= t - d; i++){
            int sum = 0;
        	for(int j = i, k = 0 ; j < t && k < d; k++, j++){
           		sum += a[k] * b[j];
                //System.out.println("ab " + a[k] + " " + b[j]);
        	}
            //System.out.println(t + " " + d + " " +  " " + sum);
            max = sum > max ? sum : max;
        } 
        
    }
}
