import java.io.*;
import java.util.*;

public class Main {
    static int[] target;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		target = new int[m];
		comb(1, 0);
		
		System.out.println(sb);
	}
	static void comb(int num, int targetIndex){
	    if(targetIndex == m){
	        for(int i = 0; i < m; i++){
	            sb.append(target[i] + " ");
	        }
	        sb.deleteCharAt(sb.length() - 1);
	        sb.append("\n");
	        return;
	    }
	    
	    for(int i = num; i <= n; i++){
	        target[targetIndex] = i;
	        comb(i, targetIndex + 1);
	    }
	}
}