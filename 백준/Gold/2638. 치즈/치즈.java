import java.util.*;
import java.io.*;

public class Main {
    static int n, m, cnt;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visit;
    static HashSet<Node> removeSet;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cnt++;
            }
        }
        int ans = 0;
        while(cnt > 0){
            removeSet = new HashSet<>();
            visit = new boolean[n][m];
            findOutside(0, 0);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 1) removeCheese(i, j);
                }
            }
            for(Node node: removeSet){
                map[node.y][node.x] = 0;
            }
            ans++;
        }
        System.out.println(ans);
    }
    static void findOutside(int y, int x){
        visit[y][x] = true;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx] || map[ny][nx] == 1) continue;
                visit[ny][nx] = true;
                map[ny][nx] = -1;
                q.offer(new Node(ny, nx));
            }
        }
    }
    static void removeCheese(int y, int x){
        int zero = 0;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] != -1) continue;
            zero++;
        }
        if(zero >= 2) {
            removeSet.add(new Node(y, x));
            cnt--;
        }
    }
    static class Node{
        int y, x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
        @Override public boolean equals(Object o) {
        if (!(o instanceof Node))
            return false;
        Node p = (Node) o;
        return p.x == x && p.y == y;
    }
    }
}
