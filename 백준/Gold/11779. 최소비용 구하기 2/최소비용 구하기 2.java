import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, start, end;
	static long answer;
	static int[] weight, ans;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Bus>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		weight = new int[n+1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		ans = new int[n+1];
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Bus(b, c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijk();
		sb.append(weight[end]).append("\n");
		searchPath();
		System.out.println(sb);
	}
	static void searchPath() {
		Deque<Integer> stack = new ArrayDeque<>();
		int cur = end;
		while(cur != start) {
			stack.push(cur);
			cur = ans[cur];
		}
		stack.push(cur);
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
	}
	static void dijk() {
		PriorityQueue<Bus> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
		pq.offer(new Bus(start, 0));
		weight[start] = 0;
		while(!pq.isEmpty()) {
			Bus bus = pq.poll();
			int x = bus.e;
			if(weight[x] < bus.c) continue;
			for(Bus now : list.get(x)) {
				if(weight[now.e] > weight[x] + now.c) {
					weight[now.e] = weight[x] + now.c;
					ans[now.e] = x;
					pq.offer(new Bus(now.e, weight[now.e]));
				}
			}
		}
	}
	static class Bus{
		int e, c;
		public Bus(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
}