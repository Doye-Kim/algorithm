import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] sensor = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
		    sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);
		int[] dist = new int[n - 1];
		for(int i = 1; i < n; i++){
		    dist[i - 1] = sensor[i] - sensor[i - 1];
		}
		Arrays.sort(dist);
		int ans = 0;
		for(int i = 0; i < n - k; i++){
		    ans += dist[i];
		}
		System.out.print(ans);
	}
}
