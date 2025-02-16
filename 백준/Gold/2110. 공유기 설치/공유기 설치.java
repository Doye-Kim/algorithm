import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] home;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        c = Integer.parseInt(arr[1]);
        home = new int[n];
        for(int i = 0; i < n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int l = 1;
        int r = home[n - 1] - home[0] + 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(isPossible(mid) < c) r = mid;
            else l = mid + 1;
            
        }
        System.out.println(l - 1);
	}
	static int isPossible(int distance){
	    int cnt = 1;
	    int last = home[0];
	    
	    for(int i = 1; i < n; i++){
	        int now = home[i];
	        if(now - last >= distance){
	            cnt++;
	            last = now;
	        }
	    }
	    return cnt;
	}
}