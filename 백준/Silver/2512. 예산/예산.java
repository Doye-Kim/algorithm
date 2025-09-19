import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int l = 0;
		int r = 0;
		for(int i = 0; i < n; i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		    r = Math.max(r, arr[i]);
		    l = Math.min(l, arr[i]);
		}
		int max = Integer.parseInt(br.readLine());
		while(l <= r){
		    int mid = (l + r) / 2;
		    int sum = 0;
		    for(int i = 0; i < n; i++){
		        if(arr[i] > mid) sum += mid;
		        else sum += arr[i];
		    }
		    if(sum <= max) l = mid + 1;
		    else r = mid - 1;
		}
		System.out.print(r);
	}
}
