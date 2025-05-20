import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] nums = new boolean[n + 1];
		
		int ans = 0;
		while(true){
		    int p = 0;
		    for(int i = 2; i <= n; i++){
		        if(!nums[i] && isPrime(i)){
		            p = i;
		            break;
		        }
		    }
		    for(int i = p; i <= n; i += p){
		        if(nums[i]) continue;
		        nums[i] = true;
		        k--;
		        if(k == 0){
		            ans = i;
		            break;
		        }
		    }
		    if(k <= 0) break;
		}
		System.out.println(ans);
	}
	static boolean isPrime(int n){
	    for(int i = 2; i < Math.sqrt(n); i++){
	        if(n % i == 0) return false;
	    }
	    return true;
	}
}
