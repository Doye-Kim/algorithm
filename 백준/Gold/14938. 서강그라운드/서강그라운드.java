import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r, max;
	static int[] items;
	static int[][] weight;
	static ArrayList<Pos>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n+1];
		weight = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(weight[i], Integer.MAX_VALUE);
		}
		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i]=new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			list[a].add(new Pos(b, l));
			list[b].add(new Pos(a, l));
		}
		max = 0;
		for(int i = 1; i <= n; i++) {
			dijk(i);
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				if(weight[i][j] <= m) cnt += items[j];
			}
			max = Math.max(cnt,  max);
		}
		System.out.println(max);
	}
	static void dijk(int start) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(start, 0));
		weight[start][start] = 0;
		while(!pq.isEmpty()) {
			Pos pos = pq.poll();
			int nv = pos.v;
			for(Pos p : list[nv]) {
				if(weight[start][p.v] > weight[start][nv] + p.c) {
					weight[start][p.v] = weight[start][nv] + p.c;
					pq.add(new Pos(p.v, weight[start][p.v]));
				}
			}
		}
	}
	static class Pos implements Comparable<Pos>{
		int v, c;
		public Pos(int v, int c) {
			this.v = v;
			this.c = c;
		}
		@Override
		public int compareTo(Pos o) {
			return c - o.c;
		}
	}
}
