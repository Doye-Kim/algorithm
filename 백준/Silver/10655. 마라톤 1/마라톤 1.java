import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		int sum = 0;
		int[][] checkpoint = new int[n][2];
		for(int i = 0; i < n; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    checkpoint[i][0] = Integer.parseInt(st.nextToken());
		    checkpoint[i][1] = Integer.parseInt(st.nextToken());
		    if(i > 0){
		        sum += Math.abs(checkpoint[i][0] - checkpoint[i - 1][0]) + Math.abs(checkpoint[i][1] - checkpoint[i - 1][1]);
		    }
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < n- 1; i++){
		    int s = sum;
		    s -= Math.abs(checkpoint[i][0] - checkpoint[i - 1][0]) + Math.abs(checkpoint[i][1] - checkpoint[i - 1][1]);
		    s -= Math.abs(checkpoint[i][0] - checkpoint[i + 1][0]) + Math.abs(checkpoint[i][1] - checkpoint[i + 1][1]);
		    s += Math.abs(checkpoint[i- 1][0] - checkpoint[i + 1][0]) + Math.abs(checkpoint[i - 1][1] - checkpoint[i + 1][1]);
		
		    min = Math.min(min, s);
		}
        System.out.print(min);
	}
}