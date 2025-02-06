import java.io.*;
import java.util.*;

public class Main {
    static int[] nums, target;
    static boolean[] selected;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		target = new int[n];
		selected = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
		    nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		perm(0);
		
		System.out.print(sb);
	}
	
	static void perm(int idx){
	    if(idx == m){
	        for(int i = 0; i < m; i++){
	            sb.append(target[i]).append(" ");
	        }
	       // sb.deleteCharAt(sb.length() - 1);
	        sb.append("\n");
	        return;
	    }
	    for(int i = 0; i < n; i++){
	        if(!selected[i]){
	            target[idx] = nums[i];
	            selected[i] = true;
	            perm(idx + 1);
	            selected[i] = false;
	        }
	    }
	}
}