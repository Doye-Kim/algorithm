import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static PriorityQueue<Node> maxheap = new PriorityQueue<>((n1, n2) -> n2.x == n1.x ? n2.num - n1.num : n2.x - n1.x);
	static PriorityQueue<Node> minheap = new PriorityQueue<>((n1, n2) -> n2.x == n1.x ? n1.num - n2.num : n1.x - n2.x);
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String o = st.nextToken();
			if(o.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				add(p, Integer.parseInt(st.nextToken()));
			}
			else if(o.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				map.remove(p);
			}
			else if(o.equals("recommend")) {
				int p = Integer.parseInt(st.nextToken());
				if(p == 1) {
					Node max;
					while(true) {
						max = maxheap.poll();
						if(!map.containsKey(max.num) || map.get(max.num) != max.x) continue;
						maxheap.add(max);
						break;
					}
					sb.append(max.num).append("\n");
				}
				else {
					Node min;
					while(true) {
						min = minheap.poll();
						if(!map.containsKey(min.num) || map.get(min.num) != min.x) continue;
						minheap.add(min);
						break;
					}
					sb.append(min.num).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	static void add(int p, int l) {
		Node n = new Node(p, l);
		maxheap.add(n);
		minheap.add(n);
		map.put(p, l);
	}
	static class Node{
		int num, x;

		public Node(int num, int x) {
			this.num = num;
			this.x = x;
		}
	}
}