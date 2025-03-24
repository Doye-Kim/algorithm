import java.io.*;
import java.util.*;
public class Main
{
    static int n;
    static String after;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    char[] before = br.readLine().toCharArray();
	    char[] before2 = before.clone();
	    before2[0] = before[0] == '0' ? '1' : '0';
	    before2[1] = before[1] == '0' ? '1' : '0';
	    after = br.readLine();
	    
	    int c1 = calcCnt(0, before);
	    int c2 = calcCnt(1, before2);
	    
	    if(c1 > -1 && c2 > -1) System.out.println(Math.min(c1, c2));
	    else if(c1 == -1 && c2 != -1) System.out.println(c2);
	    else if(c2 == -1 && c1 != -1) System.out.println(c1);
	    else System.out.println(-1);
	}
	static int calcCnt(int cnt, char[] before){
	    for(int i = 1; i < n - 1; i++){
	        if(before[i - 1] == after.charAt(i - 1)) continue;
	        else {
	            cnt++;
	            before[i - 1] = before[i - 1] == '0' ? '1' : '0';
	            before[i] = before[i] == '0' ? '1' : '0';
	            before[i + 1] = before[i + 1] == '0' ? '1' : '0';
	        }
	    }
	    if(before[n - 2] != after.charAt(n - 2)) {
	        cnt++;
	        before[n - 2] = before[n - 2] == '0' ? '1' : '0';
            before[n - 1] = before[n - 1] == '0' ? '1' : '0';
	    }
	    for(int i = 1; i < n; i++){
	        if(before[i] != after.charAt(i)) return -1;
	    }
	    return cnt;
	}
}
