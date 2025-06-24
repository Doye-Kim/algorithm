import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		String[] str = new String[n];
		int[] hd = new int[n];
		for(int i = 0; i < n; i++){
		    str[i] = br.readLine();
		}
		char[] ans = new char[m];
		Arrays.fill(ans, 'Z');
		int sum = 0;
		for(int i = 0; i < m; i++){
		    HashMap<Character, Integer> map = new HashMap<>();
		    for(int j = 0; j < n; j++){
		        map.put(str[j].charAt(i), map.getOrDefault(str[j].charAt(i), 0) + 1);
		    }
		    int max = 0;
		    for(char c : map.keySet()){
		        if(map.get(c) > max || (map.get(c) == max && c < ans[i])){
		            max = map.get(c);
		            ans[i] = c;
		        }
		    }
		    sum += (n - max);
		}
		System.out.println(new String(ans));
        System.out.println(sum);		
	}
}
