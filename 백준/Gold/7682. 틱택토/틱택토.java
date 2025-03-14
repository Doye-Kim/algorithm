import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            else sb.append(isValid(str) ? "valid" : "invalid").append("\n");
        }
        System.out.print(sb);
    }
    static boolean isValid(String str){
        int oCnt = 0;
        int xCnt = 0;
        for(int i = 0; i < 9; i++){
            if(str.charAt(i) == 'O') oCnt++;
            else if(str.charAt(i) == 'X') xCnt++;
        }
        if(oCnt > xCnt || xCnt > oCnt + 1) return false;
        int oCc = calcCnt(str, 'O');
        int xCc = calcCnt(str, 'X');
        if(oCc > 0 && xCc > 0 || (oCnt + xCnt < 9 && oCc == 0 && xCc == 0)) return false;
        
        if(xCnt == oCnt + 1 && oCc == 1) return false;
        else if(xCnt == oCnt && xCc == 1) return false;
        
        return true;
        
    }
    static int calcCnt(String str, char now){
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            if(str.charAt(i) == now && str.charAt(i+3) == now && str.charAt(i+6) == now) cnt++;
        }
        for(int i = 0; i < 9; i+=3){
             if(str.charAt(i) == now && str.charAt(i+1) == now && str.charAt(i+2) == now) cnt++;
        }
        if(str.charAt(4) == now){
            if(str.charAt(0) == now && str.charAt(8) == now)cnt++;
            if(str.charAt(2) == now && str.charAt(6) == now) cnt++;
        }
        return cnt;
    }
}
