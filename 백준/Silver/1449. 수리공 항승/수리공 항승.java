import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] water = new int[n];
		for(int i = 0; i < n; i++){
		    water[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		int ans = 0;
		Arrays.sort(water);
		for(int i = 0; i < n; i++){
		    if(water[i] > tmp){
		        ans++;
		        tmp = water[i];
		        tmp += l - 1;
		    }
		}
		System.out.println(ans);
	}
}
