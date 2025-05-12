import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] blog = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int cnt = 0;
		int sum = 0;
		for(int i = 1; i <= n; i++){
		    blog[i] = Integer.parseInt(st.nextToken());
		    sum += blog[i];
		    if(i >= x){
		        sum -= blog[i - x];
		        if(sum > max) {
		            max = sum;
		            cnt = 1;
		        }
		        else if(sum == max) cnt++;
		    }
		}
		if(max == 0){
		    System.out.println("SAD");
		}
		else{
		    System.out.println(max + "\n" + cnt);
		}
	}
}
