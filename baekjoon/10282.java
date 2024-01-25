package boj10282;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int n, d, c, cnt, max;
	static boolean[] isVisited;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
		
			n = Integer.parseInt(str[0]);
			d = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]) - 1;
			cnt = 1;
			isVisited = new boolean[n];
			list = new ArrayList[n];
			for(int i = 0; i < n; i++){
	            list[i] = new ArrayList<>();
	        }
	
			for(int i = 0; i < d; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]) - 1;
				int b = Integer.parseInt(s[1]) - 1;
				int t = Integer.parseInt(s[2]);
				
				list[b].add(new Node(a, t));
			}
			System.out.println(cnt + " " + dijk());
		}
	}
	static int dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] times = new int[n];
		Arrays.fill(times, Integer.MAX_VALUE);
		pq.add(new Node(c, 0));
		isVisited[c] = true;
		times[c] = 0;

		while(!pq.isEmpty()) {
			Node pos = pq.poll();
			int na = pos.a;
			if(isVisited[na]) continue;
			isVisited[na] = true;
			for(Node node : list[na]) {
				if(times[node.a] > times[na] + node.time) {
					times[node.a] = times[na] + node.time;
					pq.add(new Node(node.a, times[node.a]));
					System.out.println(times[node.a]);
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer = answer > times[i] ? answer : times[i];
		}
		return answer;
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
