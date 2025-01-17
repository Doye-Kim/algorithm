import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] dt = {-1, 1, 2};
    static boolean[] visit = new boolean[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
    }
    static int bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(n, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.time == k) return node.cnt;
            for(int d = 0; d < 3; d++){
                int nt = 0;
                if(d == 2) nt = node.time * dt[d];
                else nt = node.time + dt[d];
                if(nt < 0 || nt > 100000 || visit[nt]) continue;
                visit[nt] = true;
                q.offer(new Node(nt, node.cnt + 1));
            }
        }
        return 0;
    }
    static class Node{
        int time, cnt;
        public Node(int time, int cnt){
            this.time = time;
            this.cnt = cnt;
        }
    }
}
