import java.io.*;
import java.util.*;
public class Main
{
    static int n;
    static boolean[] after, b1, b2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    int[] sx = new int[n];
	    int[] sy = new int[n];
	    boolean[] visit = new boolean[n];
	    for(int i = 0; i < n; i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        sx[i] = Integer.parseInt(st.nextToken());
	        sy[i] = Integer.parseInt(st.nextToken());
	    }
	    int answer = 0;
	    for(int i = 0; i < n; i++){
	        int height = sy[i];
	        if(height == 0 || visit[i]) continue;
	        for(int j = i; j < n; j++){
	            if(sy[j] < height) break;
	            else if(sy[j] == height) visit[j] = true;
	        }
	        answer++;
	    }
	    System.out.println(answer);
	}
}
