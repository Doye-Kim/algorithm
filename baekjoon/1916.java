import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m, u, v;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		int[] arr = new int[n];
		Arrays.fill(arr, Integer.MAX_VALUE);
		boolean[] isVisited = new boolean[n];
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nu = Integer.parseInt(st.nextToken()) - 1;
			int nv = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			list[nu].add(new Node(nv, c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken()) - 1;
		v = Integer.parseInt(st.nextToken()) - 1;
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(u, 0));
		arr[u] = 0;
		
		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int cu = pos.end;
			
			if(isVisited[cu]) continue;
			isVisited[pos.end] = true;
			for(Node node : list[cu]) {
				if(arr[node.end] > arr[cu] + node.cost) {
					arr[node.end] = arr[cu] + node.cost;
					pq.add(new Node(node.end, arr[node.end]));
				}
			}
		}
		System.out.println(arr[v]);
	}
}
class Node implements Comparable<Node>{
	int end, cost;
	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
	
}
