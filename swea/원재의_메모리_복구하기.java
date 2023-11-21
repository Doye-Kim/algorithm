// D3
// 1289. 원재의 메모리 복구하기


import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String memory = sc.next();
            int answer = 0;
            
            if(fmemory.charAt(0) == '1') answer++;
            for(int i = 1; i < memory.length(); i++){
            	if(memory.charAt(i - 1) != memory.charAt(i)) answer++;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
