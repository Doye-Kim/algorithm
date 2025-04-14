import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		int[] length = new int[n];
		int[] price = new int[n];
		for(int i = 1; i < n; i++){
		    length[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++){
		    price[i] = Integer.parseInt(st.nextToken());
		}

		long now = price[0];
	    for(int i = 1; i < n; i++){
	        sum += (length[i] * now);
	        if(now > price[i]) {
	            now = price[i];
	        }
	    }
	    System.out.println(sum);
	}
}
