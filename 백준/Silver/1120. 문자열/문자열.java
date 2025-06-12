import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		String a = arr[0];
		String b = arr[1];
		int n = b.length() - a.length();
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n; i++){
		    int cnt = 0;
		    for(int j = 0; j < a.length(); j++){
		        if(a.charAt(j) != b.charAt(i + j)) cnt++;
		    }
		    min = Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
