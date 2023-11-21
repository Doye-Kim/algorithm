// D3
// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드

import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        T=sc.nextInt();
        // 0부터 9까지의 숫자 암호 코드
        String[] number = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String tmp = "";
            int endPoint = 0;
            for(int i = 0; i < N; i++){
                String st = sc.next();
                for(int j = 0; j < M; j++){
                    if(st.charAt(j) == '1'){
                        tmp = st;
                        endPoint = j;
                    }
                }
            }
            // 전체 암호 코드
            String password = tmp.substring(endPoint - 55, endPoint + 1);
            // 암호 코드 7자리씩 나눈 것
            String[] passwordNumbers = new String[8];
            // 해당 암호 코드 숫자
            int[] passwordNumber = new int[8];
            for(int i = 0, j = 0; i < 8; i++, j+=7){
                passwordNumbers[i] = password.substring(j, j+7);
            }
            int sum = 0;
            int odd = 0; // 홀수
            int even = 0; // 짝수
            for(int i = 0; i <8; i++){
                for(int j = 0; j < 10; j++){
                    if(passwordNumbers[i].equals(number[j])) passwordNumber[i] = j;
                }
                // passwordNumber의 인덱스가 0부터 시작이라 
                // 인덱스의 홀/짝과 반대로 적용
                if(i % 2 == 0) odd += passwordNumber[i];
                if(i % 2 != 0) even += passwordNumber[i];
                sum += passwordNumber[i];
            }
            if(((odd * 3 + even) % 10) == 0) System.out.println("#" + test_case + " " + sum);
            else System.out.println("#" + test_case + " 0");
        }
    }
}
