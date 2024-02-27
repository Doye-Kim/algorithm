import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int v, e, start;
	static int[] cost;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());	
		cost = new int[v+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		start = Integer.parseInt(br.readLine());
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Node(v, w));
		}
		dijk();
		for(int i = 1; i <= v; i++) {
			sb.append(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)-> n1.w - n2.w);
		pq.offer(new Node(start, 0));
		cost[start] = 0;
		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int x = pos.v;
			for(Node node : list.get(x)) {
				if(cost[node.v] > cost[x] + node.w) {
					cost[node.v] = cost[x] + node.w;
					pq.offer(new Node(node.v, cost[node.v]));
				}
			}
		}
	}
	static class Node{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}