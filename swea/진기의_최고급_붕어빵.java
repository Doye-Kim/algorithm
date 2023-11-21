// D3
// 1860. 진기의 최고급 붕어빵


import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String[] result = {"Impossible", "Possible"};
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); // 사람 수
            int M = sc.nextInt(); // M초에
            int K = sc.nextInt(); // K개
            int[] times = new int[N];
            int res = 1;
            for(int i = 0; i < N; i++){
            	times[i] = sc.nextInt();
            }
            Arrays.sort(times);
            
            System.out.println("#" + test_case + " " + result[check(times, M, K)]);
		}
	}
    static int check(int[] times, int M, int K){
        for(int i = 0; i < times.length; i++){
                    if((times[i] / M) * K < i + 1) return 0;
                }
        return 1;
    }
}
