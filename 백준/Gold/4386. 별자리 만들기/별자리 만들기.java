import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[] visit;
    static Node[] stars;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stars = new Node[n];
        visit = new boolean[n];
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Node(x, y);
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                double d = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
                list.get(i).add(new Edge(j, d));
            }
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        double ans = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(visit[now.end]) continue;
            visit[now.end] = true;
            ans += now.dist;
            
            for(Edge next : list.get(now.end)){
                if(visit[next.end]) continue;
                pq.offer(next);
            }
        }
        System.out.printf("%.2f", ans);
    }
    static class Node{
        double x, y;
        public Node(double x, double y){
            this.y = y;
            this.x = x;
        }
    }
    static class Edge implements Comparable<Edge>{
        int end;
        double dist;
        Edge(int end, double dist){
            this.end = end;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge e){
            if (this.dist > e.dist) return 1;
            else if (this.dist < e.dist) return -1;
            return 0;
        }
    }
}
