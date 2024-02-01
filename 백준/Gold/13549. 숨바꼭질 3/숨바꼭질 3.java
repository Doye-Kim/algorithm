import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k, min;
	static boolean[] isVisited;
	static int[] move = {1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		isVisited = new boolean[100001];
		int t = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(n, t));

		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int nx = pos.end;
			t = pos.time;
			isVisited[nx] = true;

			if(nx == k) {
				min = min < t ? min : t;
			}
			if(t > min) continue;

			Node node;

			for(int i = 0; i < 3; i++) {
				if(i == 2) {
					node = new Node(nx * 2, t);
				}
				else {
					node = new Node(nx + move[i], t + 1);
				}
				if(node.end < isVisited.length && node.end >= 0&& node.time < min && !isVisited[node.end]) {
					pq.add(node);
				}
			}
		}
		System.out.println(min);
	}

}
class Node implements Comparable<Node>{
	int end, time;
	
	public Node(int end, int time) {
		this.end = end;
		this.time = time;
	}

	@Override
	public int compareTo(Node o) {
		return time - o.time;
	}
}