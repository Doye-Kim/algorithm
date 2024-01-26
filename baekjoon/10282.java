package boj10282;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int n, d, c, cnt, max;
	static boolean[] isVisited;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken()) - 1;
			isVisited = new boolean[n];
			list = new ArrayList[n];
			cnt = 0;
			for(int i = 0; i < n; i++){
	            list[i] = new ArrayList<>();
	        }
	
			for(int i = 0; i < d; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken()) - 1;
				int b = Integer.parseInt(st2.nextToken()) - 1;
				int t = Integer.parseInt(st2.nextToken());
				
				list[b].add(new Node(a, t));
			}
			dijk();
		}
	}
	static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] times = new int[n];
		Arrays.fill(times, Integer.MAX_VALUE);
		pq.add(new Node(c, 0));
		times[c] = 0;

		while(!pq.isEmpty()) {
			Node pos = pq.poll();

			int na = pos.a;
			if(isVisited[na]) continue;
			isVisited[na] = true;
			cnt++;
			for(Node node : list[na]) {
				if(times[node.a] > times[na] + node.time) {
					times[node.a] = times[na] + node.time;
					pq.add(new Node(node.a, times[node.a]));
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < n; i++) {
			if(times[i] == Integer.MAX_VALUE) continue;
			answer = answer > times[i] ? answer : times[i];
		}
		System.out.println(cnt + " " + answer);
	}
}
class Node implements Comparable<Node>{
	int a, time;
	public Node(int a, int time) {
		this.a = a;
		this.time = time;
	}
	@Override
	public int compareTo(Node o) {
		return this.time - o.time;
	}
}
