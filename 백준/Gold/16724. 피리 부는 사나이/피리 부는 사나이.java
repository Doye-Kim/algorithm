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
	    char[] dir = {'U', 'D', 'L', 'R'};
	    int[] dy = {-1, 1, 0, 0};
	    int[] dx = {0, 0, -1, 1};
	    
	    for(int i = 0; i < n; i++){
	        String str = br.readLine();
	        for(int j = 0; j < m; j++){
	            char now = str.charAt(j);
	            for(int d = 0; d < 4; d++){
	                if(now == dir[d]){
	                    int ny = i + dy[d];
	                    int nx = j + dx[d];
	                    union(m * i + j, m * ny + nx);
	                }
	            }
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
