// D3
// 1220. [S/W 문제해결 기본] 5일차 - Magnetic

import java.util.Scanner;

class Solution
{
    static int WH = 100;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[][] magnets = new int[WH][WH];
            int cnt = 0;
			sc.nextInt();
            for(int i = 0; i < WH; i++){
            	for(int j = 0; j < WH; j++){
                	magnets[i][j] = sc.nextInt();
                }
            }
             //1: N, 2: S, up: N, down: S
             
             // j는 가로
            for(int j = 0; j < WH; j++){
                int last = 0;
                // 세로줄 비교하기
            	for(int i = 0; i < WH; i++){
                	if(magnets[i][j] == 1) last = 1;
                    // 1<->2가 만나는 순간 교착상태
                    // last가 2인 상태에서 또 2가 나오는 건 
                    // N극 n개와 S극 m개가 마주쳤을 때, 교착상태는 한 개이다.
                    // 이걸 이유로 고려하지 않음
                    if(magnets[i][j] == 2 && last == 1){
                    	cnt++;
                        last = 2;
                    }
                }           
            }
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}
