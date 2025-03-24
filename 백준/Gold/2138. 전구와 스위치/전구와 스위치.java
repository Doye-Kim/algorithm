import java.io.*;
import java.util.*;
public class Main
{
    static int n;
    static boolean[] after, b1, b2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    String before = br.readLine();
	    String afterTmp = br.readLine();
	    b1 = new boolean[n];
	    b2 = new boolean[n];
	    after = new boolean[n];
        
	    for(int i = 0; i < n; i++){
	        if(before.charAt(i) == '0') {
	            b1[i] = false;
	            b2[i] = false;
	        }
	        else {
	            b1[i] = true;
	            b2[i] = true;
	        }
	    }
	    b2[0] = !b2[0];
	    b2[1] = !b2[1];
	    
	    for(int i = 0; i < n; i++){
	        if(afterTmp.charAt(i) == '0') after[i] = false;
	        else after[i] = true;
	    }
	    
	    int c1 = 0;
	    int c2 = 1;
	    
	    for(int i = 1; i < n; i++){
	        if(b1[i - 1] != after[i - 1]) {
	            c1++;
	            onOff(i, b1);
	        }
	        if(b2[i - 1] != after[i - 1]) {
	            c2++;
	            onOff(i, b2);
	        }
	    }
	    
	    for(int i = 1; i < n; i++){
	        if(b1[i] != after[i]) c1 = Integer.MAX_VALUE;
	        if(b2[i] != after[i]) c2 = Integer.MAX_VALUE;
	    }
	    int answer = Math.min(c1, c2);
	    
	    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	static void onOff(int i, boolean[] before){
	    before[i - 1] = !before[i - 1];
        before[i] = !before[i];
        if(i < n - 1) before[i + 1] = !before[i + 1];
	}
}
