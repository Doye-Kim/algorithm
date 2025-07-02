import java.util.*;
import java.io.*;
public class Main
{
    static int n, m;
    static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for(int i = 0; i <= n; i++){
		    parent[i] = i;
		}
		for(int i = 0; i < m; i++){
		    st = new StringTokenizer(br.readLine());
		    int input = Integer.parseInt(st.nextToken());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    if(input == 0){
		        union(a, b);
		    }
		    else {
		        if (find(a) == find(b)) sb.append("YES").append("\n");
		        else sb.append("NO").append("\n");
		    }
		}
		System.out.print(sb);
	}
	static void union(int a, int b){
	    int pa = find(a);
	    int pb = find(b);
	    
	    if(pa == pb) return;
	    
	    if(pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
	}
	
	static int find(int a){
	    if (a != parent[a]) {
        parent[a] = find(parent[a]);
        }
        return parent[a];
	}
}
