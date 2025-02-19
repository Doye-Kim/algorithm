import java.util.*;
import java.io.*;

public class Main {
    static int v, e;
    static int[] dist;
    static int max = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v+1];
        Arrays.fill(dist, max);
        for(int i = 0; i <= v; i++){
            list.add(new ArrayList<>());
        }
        int start = Integer.parseInt(br.readLine());
        for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Node(v, w));
		}
		dijk(start);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= v; i++){
		    sb.append(dist[i] == max ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
    }
    static void dijk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.cost - n2.cost);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(dist[node.end] < node.cost) continue;
            for(Node n: list.get(node.end)){
                int nd = dist[node.end] + n.cost;
                if(dist[n.end] > nd){
                    pq.offer(new Node(n.end, nd));
                    dist[n.end] = nd;
                }
            }
        }
        
    }
    static class Node{
        int end, cost;
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
}
