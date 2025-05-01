import java.util.*;
import java.io.*;

public class Main
{
    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();
    static int n, d;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    d = Integer.parseInt(st.nextToken());
	    dist = new int[d + 1];
	    for(int i = 0; i <= d; i++){
	        dist[i] = Integer.MAX_VALUE;
	        list.add(new ArrayList<>());
	    }
	    for(int i = 0; i < n; i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        if (b > d || c >= (b - a)) continue;
	        list.get(a).add(new Node(b, c));
	    }
	    dijk();
	    System.out.println(dist[d]);
	}
	static void dijk(){
	    PriorityQueue<Node> q = new PriorityQueue<>();
	    dist[0] = 0;
	    q.offer(new Node(0, 0));
	    while(!q.isEmpty()){
	        Node now = q.poll();
	        if (dist[now.e] < now.c) continue;
	        for(Node node : list.get(now.e)){
	            int ne = node.e;
	            if(dist[ne] > dist[now.e] + node.c){
	                dist[ne] = dist[now.e] + node.c;
	                q.offer(new Node(ne, dist[ne]));
	            }
	        }
	        if (now.e + 1 <= d && dist[now.e + 1] > dist[now.e] + 1) {
                dist[now.e + 1] = dist[now.e] + 1;
                q.offer(new Node(now.e + 1, dist[now.e + 1]));
            }
	    }
	}
	static public class Node implements Comparable<Node> {
	    int e, c;
	    public Node(int e, int c){
	        this.e = e;
	        this.c = c;
	    }
	    public int compareTo(Node o) {
            return this.c - o.c;
        }
        public String toString(){
            return e + " " + c;
        }
	}
}
