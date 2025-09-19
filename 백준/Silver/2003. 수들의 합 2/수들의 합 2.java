import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];

		for(int i = 0; i < n; i++){
		    a[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = 0;
		int cnt = 0;
		while(true){
		    if(sum < m) sum += a[r++];
		    else if(sum > m) sum -= a[l++];
		    else {
		        cnt++;
		        sum -= a[l++];
		    }
		    if(r == n && sum < m) break;
		}
		System.out.print(cnt);
	}
}
