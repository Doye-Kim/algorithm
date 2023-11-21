// D3
// 1234. [S/W 문제해결 기본] 10일차 - 비밀번호 D3

import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T= 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            String tmp = sc.next();
            for(int i = 0; i < n; i++){
            	list.add(tmp.charAt(i) - '0');
            }
            
			// 반복의 끝을 알리는 변수 end
            boolean end = false;
            while(!end){
                if(end) break;
            	for(int i = 0; i < n; i++){
                	// i가 n-1일 때까지 순회했다면 중복되는 쌍이 없는 것
                     if(i == n - 1) {
                        end = true;
                         break;
                    }
                    //연속으로 중복일 때 처리
                	if(list.get(i) == list.get(i+1)) {
                        list.remove(i); 
                        list.remove(i);
                        n -= 2;
                        break;
                    }
               }
            }
            System.out.print("#" + test_case + " ");
           	for(int i = 0; i < list.size(); i++){
            	System.out.print(list.get(i));
            }
            System.out.println();
		}
	}
}
