import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		int cnt = 0;
		for(int i = 0; i < n; i++){
		    String str = br.readLine();
		    if(str.equals("ENTER")){
		        cnt += set.size();
		        set = new HashSet<>();
		    }
		    else set.add(str);
		}
		cnt += set.size();
		System.out.print(cnt);
	}
}
