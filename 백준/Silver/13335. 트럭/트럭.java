import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[n];
		int[] time = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
		    weight[i] = Integer.parseInt(st.nextToken());
		}
		int t = 1;
		int now = 0;
		int inIdx = 0;
		int outIdx = 0;
		while(true){
            if(t == time[outIdx] + w){
		        now -= weight[outIdx];
		        outIdx++;
		    }
		    if(now + weight[inIdx] <= l && inIdx - outIdx < w){
		        now += weight[inIdx];
		        time[inIdx] = t;
		        if(inIdx == n - 1) break;
		        inIdx++;
		    }
		    t++;
		}
		System.out.println(time[n - 1] + w);
	}
}
