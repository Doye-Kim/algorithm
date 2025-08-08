import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] subs= new int[n];
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    subs[i] = b - a;
		}
		Arrays.sort(subs);
		int ans = 0;
		if(subs[k - 1] > 0) ans = subs[k - 1];
		System.out.print(ans);
	}
}
