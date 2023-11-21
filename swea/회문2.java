// D3
// 1216. [S/W 문제해결 기본] 3일차 - 회문2

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static boolean palindrome(StringBuffer sb) {
		String str1 = sb.toString();
		String str2 = sb.reverse().toString();
		sb.reverse();
		if (str1.equals(str2))
			return true;
		return false;
	}
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10; // 테스트케이스 개수
        int WH = 100; //가로 세로 길이

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int Tnum = Integer.parseInt(br.readLine());
			StringBuffer[] colSb = new StringBuffer[WH];
			for (int i = 0; i < WH; i++) {
				colSb[i] = new StringBuffer();
			}
			StringBuffer sb;
		
        int max = 0;
			for (int i = 0; i < WH; i++) { // 한 줄 입력받고, 가로 확인
				String inputLine = br.readLine();
				for (int j = 0; j < WH; j++) { // 세로 확인용 sb에 저장
					colSb[j].append(inputLine.charAt(j));
				}
				for (int n = WH; n > max; n--) { // 체크 할 글자수
					for (int k = 0; k <= WH - n; k++) { // 글자수로 한 줄에 몇 번 체크 할지 계산
						sb = new StringBuffer(inputLine.substring(k, k + n));
						if (palindrome(sb)) {
							max = n;
							break; // 100부터 -- 했으니까 max찾으면 끝
						}
					}
                }
            }
            for (int i = 0; i < 100; i++) { // 세로 확인
				String colLine = colSb[i].toString();
				for (int n = WH; n > max; n--) { // 체크 할 글자수
					for (int k = 0; k <= WH - n; k++) { // 글자수로 한 줄에 몇 번 체크 할지 계산
						sb = new StringBuffer(colLine.substring(k, k + n));
						if (palindrome(sb)) {
							max = Math.max(max, n);
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", Tnum, max);
		}
    }
}
