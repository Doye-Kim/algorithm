import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n + 1];
		for(int i = 1; i <= n; i++){
		    num[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = n ; i > 0; i--){
		    list.add(num[i], i);
		}
		
		for(int h : list){
		    System.out.print(h + " ");
		}
	}
}
