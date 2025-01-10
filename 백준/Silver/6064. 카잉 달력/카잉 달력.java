import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int m = Integer.parseInt(st.nextToken());
		    int n = Integer.parseInt(st.nextToken());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    int ans = -1;
		    int d = x;

		    while(d <= m * n){
		        if(d % n == y || (d % n == 0 && n == y)) {
		            ans = d;
		            break;
		        }
		        d += m;
		    }
    		System.out.println(ans == -1 ? ans : d);
		}
	}
}
