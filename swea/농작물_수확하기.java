// D3
// 2805. 농작물 수확하기


import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();

            int[][] rc = new int[N][N];
            for(int i = 0; i < N; i++){
            	String st = sc.next();
                for(int j = 0; j < N; j++){
                	rc[i][j] = st.charAt(j) - '0';
                }
            }
            int sum = 0;
            int standard = N / 2; //기준점
            int x = 0; //범위
            boolean max = false; //기준점에 다다랐는지 확인
            for(int i = 0; i < N; i++){
            	for(int j = standard - x; j <= standard + x; j++){
                    //System.out.println(i +"  " + j + "  " + rc[i][j]);
                	sum += rc[i][j];
                }
                //기준점에 다다랐을 경우 max를 true로
                if(x == standard) max = true;
                if(max == false) x++;
                else x--;
            }
            System.out.println("#" + test_case + " " + sum);
		}
	}
}
