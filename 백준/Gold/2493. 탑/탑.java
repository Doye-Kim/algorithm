import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] top = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = n - 1; i > 0; i--) {
			if(top[i] <= top[i - 1]) top[i] = i;
			else {
				pq.add(new Node(i, top[i]));
				top[i] = 0;
			}
			if(!pq.isEmpty() && pq.peek().value <= top[i - 1]) {
				while(true) {
					Node pos = pq.poll();
					//System.out.println(pos.index + " " + pos.value);
					top[pos.index] = i;	
					if(pq.isEmpty() || pq.peek().value > top[i - 1]) break;
				}
			}
		}
		top[0] = 0;
		for(int i = 0; i < n; i++) {
			sb.append(top[i]).append(" ");
		}
		System.out.println(sb);
	}
	static class Node implements Comparable<Node>{
		int index, value;
		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
	}
}
