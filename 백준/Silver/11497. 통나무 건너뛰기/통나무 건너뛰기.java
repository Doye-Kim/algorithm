import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++){
		    int n = Integer.parseInt(br.readLine());
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int[] logs = new int[n];
		    int[] newLogs = new int[n];
		    for(int i = 0; i < n; i++){
		        logs[i] = Integer.parseInt(st.nextToken());
		    }
		    Arrays.sort(logs);
		    int l = 0;
		    int r = n - 1;
		    for(int i = 0; i < n; i++){
		        if(i % 2 == 0) newLogs[l++] = logs[i];
		        else newLogs[r--] = logs[i];
		    }
		    int ans = 0;
		    for(int i = 0; i < n - 1; i++) {
                ans = Math.max(ans, Math.abs(newLogs[i] - newLogs[i + 1]));
            }
            sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
