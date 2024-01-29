import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m , k, start;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		start =  Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Node>[] list = new ArrayList[n];
		int[] w = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(w, Integer.MAX_VALUE);
		for(int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken()) - 1;
			int e = Integer.parseInt(st2.nextToken()) - 1;
			list[s].add(new Node(e, 1));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		w[start] = 0;
		boolean[] isVisited = new boolean[n];
		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int x = pos.end;
			if(isVisited[x]) continue;
			isVisited[x] = true;
			for(Node node : list[x]) {
				if(w[node.end] > w[x] + node.dist) {
					w[node.end] = w[x] + node.dist;
					pq.add(new Node(node.end, w[node.end]));
				}
			}
		}
		boolean isZero = true;
		for(int i = 0; i < n; i++) {
			if(w[i] == k) {
				System.out.println(i + 1);
				isZero = false;
			}
		}
		if(isZero) System.out.println(-1);
		
	}

}
class Node implements Comparable<Node>{
	int end, dist;
	public Node(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}
	@Override
	public int compareTo(Node o) {
		return dist - o.dist;
	}
}
