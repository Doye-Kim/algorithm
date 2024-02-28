import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int v, e;
	static int[] parent;
	static long ans;
	static Edge[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v+1];
		list = new Edge[e];
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[i] = new Edge(a, b, c);
		}
		Arrays.sort(list);
		makeSet();
		int cnt = 0;
		for(int i = 0; i < e; i++) {
			if(!union(list[i].v1, list[i].v2)) continue;
			ans += list[i].c;
			cnt++;
			if(cnt == v-1) break;
		}
		System.out.println(ans);
	}

	static void makeSet() {
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	static boolean union(int v1, int v2) {
		int pa = findSet(v1);
		int pb = findSet(v2);
		
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