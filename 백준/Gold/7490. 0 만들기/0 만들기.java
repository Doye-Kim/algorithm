import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[] operator = {' ', '+', '-'};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            char[] charArr = new char[n * 2 - 1];
            dfs(0, 1, charArr);
            sb.append("\n");
        }

        
        System.out.println(sb);
    }
    static void dfs(int idx, int num, char[] charArr){
        // System.out.println(idx + " " + num + " " + Arrays.toString(charArr));
        if(idx == n * 2 - 1){
            if(calc(charArr)) sb.append(new String(charArr)).append("\n");
            return;
        }
        if(idx % 2 == 0) {
            // System.out.println("?" + num  +" " + (char)(num + '0'));
            charArr[idx] = (char)(num + '0');
            dfs(idx + 1, num + 1, charArr);
        }
        else{
            for(int i = 0; i < 3; i++){
                charArr[idx] = operator[i];
                dfs(idx + 1, num, charArr);
            }
        }
    }
    static boolean calc(char[] exp){
        int sum = 0;
        int pNum = 0;
        char pOp = '+';
        for(int i = 0; i < exp.length; i++){
            char now = exp[i];
            if(Character.isDigit(now)){
                pNum += now - '0';
            }
            else{
                if(now == ' ') {
                    pNum *= 10;
                    continue;
                }
                else if(pOp == '+') sum += pNum;
                else if(pOp == '-') sum -= pNum;
                pNum = 0;
                pOp = now;
            }
        }
        if(pNum != 0) {
            if(pOp == '+') sum += pNum;
            else if(pOp == '-') sum -= pNum;
        }
        return sum == 0;
    }
}
