import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		set.add("ChongChong");
		for(int i = 0; i < n; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    String a = st.nextToken();
		    String b = st.nextToken();
		    if(set.contains(a) || set.contains(b)){
		        set.add(a);
		        set.add(b);
		    }
		}
		System.out.print(set.size());
	}
}
