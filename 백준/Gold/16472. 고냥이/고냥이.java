import java.io.*;
import java.util.*;

public class Main {
    static int[] target;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		HashMap<Character, Integer> map = new HashMap<>();
		int ans = 0;
		int idx = 0;
		for(int i = 0; i < str.length(); i++){
		    char key = str.charAt(i);
		    map.put(key, map.getOrDefault(key, 0) + 1);
		    while(map.size() > n){
		        char deleteKey = str.charAt(idx);
		        int cnt = map.get(deleteKey) - 1;
		        if(cnt == 0) map.remove(deleteKey);
		        else map.put(deleteKey, cnt);
		        idx++;
		    }
            ans = Math.max(i - idx + 1, ans);
		}
        System.out.println(ans);
	}
}