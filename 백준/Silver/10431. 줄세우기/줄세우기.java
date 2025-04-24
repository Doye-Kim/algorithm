import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for(int t = 0; t < T; t++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int[] list = new int[20];
	        int cnt = 0;
	        for(int i = 0; i < 20; i++){
	            list[i] = Integer.parseInt(st.nextToken());
	            int first = -1;
	            for(int j = 0; j < i; j++){
	                if(list[j] > list[i]) {
	                    first = j;
	                    break;
	                }
	            }
	            if(first != -1){
	                cnt += i - first;
	                int tmp = list[i];
	                for(int j = 19; j > first; j--){
	                    list[j] = list[j - 1];
	                }
	                list[first] =  tmp;
	            }
	        }
	        sb.append(n).append(" ").append(cnt).append("\n");
	    }
	    System.out.print(sb);
	}
}
