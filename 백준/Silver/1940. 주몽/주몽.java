import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int cnt = 0;
		int l = 0; 
		int r = n - 1;
		while(l < r){
		    int sum = num[l] + num[r];
		    if(sum == m) {
		        cnt++;
		        l++;
		        r--;
		    }
		    else if(sum < m) l++;
		    else r--;
		}
		System.out.println(cnt);
	}
}
