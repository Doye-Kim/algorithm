import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, E;
	static ArrayList<Node>[] list;
	static int[][] weight;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }
		weight = new int[N + 1][N + 1];
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(weight[i], Integer.MAX_VALUE);			
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1에서 출발, v1에서 출발, v2에서 출발
//		dijk(1, v1) + dijk(v1, v2) + dijk(v2, N)
//		dijk(1, v2) + dijk(v2, v1) + dijk(v1, N)
		int[] visit = {1, v1, v2};
		int[] ans1 = new int[3];
		int[] ans2 = new int[3];
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0; i < 3; i++) {
			dijk(visit[i]);
		}
		//System.out.println(Arrays.deepToString(weight));
		ans1[0] = weight[1][v1];
		ans2[0] = weight[1][v2];
		ans1[1] = weight[v1][v2];
		ans2[1] = weight[v1][v2];
		ans1[2] = weight[v2][N];
		ans2[2] = weight[v1][N];
		
		for (int i = 0; i < 3; i++) {
			if(ans1[i] == Integer.MAX_VALUE) cnt1 = Integer.MAX_VALUE;
			if(ans2[i] == Integer.MAX_VALUE) cnt2 = Integer.MAX_VALUE;
		}
		
		int answer = 0;

		if(cnt1 == Integer.MAX_VALUE && cnt2 == Integer.MAX_VALUE) {
			answer = -1;
		}
		if(cnt1 == 0){
			for(int i = 0; i < 3; i++) {
				cnt1 += ans1[i];
			}
		}
		if(cnt2 == 0) {
			for(int i = 0; i < 3; i++) {
				cnt2 += ans2[i];
			}
		}
		if(answer == -1) System.out.println(answer);
		else System.out.println(cnt1 > cnt2 ? cnt2 : cnt1);
	}
	static void dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		weight[start][start] = 0;
		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int nx = pos.end;
			int nw = pos.weight;

			for(Node node : list[nx]) {
				if(weight[start][node.end] > weight[start][nx] + node.weight) {
					//System.out.println(weight[start][node.end] + " " + (weight[start][nx] + node.weight));
					weight[start][node.end] = weight[start][nx] + node.weight;
					pq.add(new Node(node.end, weight[start][node.end]));
					//System.out.println(start + " " + node.end + " " + weight[start][node.end]);
				}
			}
		}
	}
}
class Node implements Comparable<Node>{
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
	
}