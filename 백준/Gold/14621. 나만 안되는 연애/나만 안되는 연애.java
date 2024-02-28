import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[] mw;
	static Edge[] list;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mw = new char[n+1];
		parent = new int[n+1];
		list = new Edge[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			mw[i] = st.nextToken().charAt(0);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[i] = new Edge(a,b, c);
		}
		Arrays.sort(list);
		
		makeSet();
		
		int ans = 0;
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			if(mw[list[i].v1] != mw[list[i].v2] && union(list[i].v1, list[i].v2)) {
				ans += list[i].c;
				cnt++;
				if(cnt == n-1) break;
			}
		}
		System.out.println(cnt != n-1 ? -1 : ans);
	}
	static void makeSet() {
		for(int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa == pb) return false;
		
		if(pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
        
		return true;
	}
	static class Edge implements Comparable<Edge>{
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return c - o.c;
		}
	}
}