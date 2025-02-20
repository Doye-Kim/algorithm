import java.util.*;
import java.io.*;

public class Main {
    static int n, m, t, s, g, h;
    static int[] dist;
    static ArrayList<Integer> endList;
    static int max = 100_000_000;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int te = 0; te < T; te++){
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            endList = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                list.add(new ArrayList<>());
            }
            dist = new int[n+1];
            Arrays.fill(dist, max);
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if((a == g && b == h) || (a == h && b == g)) {
                    list.get(a).add(new Node(b, d * 2 - 1));
                    list.get(b).add(new Node(a, d * 2 - 1));
                }
                else{
                    list.get(a).add(new Node(b, d * 2));
                    list.get(b).add(new Node(a, d * 2));
                }
            }
            for(int i = 0; i < t; i++){
                endList.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(endList);
            dijk(s);
            for(int i = 0; i < t; i++){
                int now = endList.get(i);
                if(dist[now] % 2 == 1) sb.append(now).append(" ");
		    }
		    sb.deleteCharAt(sb.length() - 1);
		    sb.append("\n");
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
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
