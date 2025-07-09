import java.util.*;
import java.io.*;
public class Main
{
    static int[] parent;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] arr = br.readLine().split(" ");
	    int n = Integer.parseInt(arr[0]);
	    int m = Integer.parseInt(arr[1]);
	    int s = n * m;
	    parent = new int[s];
	    for(int i = 0; i < s; i++){
	        parent[i] = i;
	    }
	    
	    for(int i = 0; i < n; i++){
	        String str = br.readLine();
	        for(int j = 0; j < m; j++){
	            int ny = i, nx = j;
                char now = str.charAt(j);
                if (now == 'U') ny--;
                else if (now == 'D') ny++;
                else if (now == 'L') nx--;
                else if (now == 'R') nx++;
                union(i * m + j, ny * m + nx);
	        }
	    }
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < s; i++){
	        set.add(find(i));
	    }
	    System.out.print(set.size());
	}
	static void union(int a, int b){
	    a = find(a);
	    b = find(b);
	    if(a == b) return;
	    else parent[b] = a;
	}
	
	static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
	}
}
