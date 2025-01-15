import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int n, m, sum = 0;
    static Node start;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                map[i][j] = arr[j];
                if(arr[j] == 'I') {
                     start = new Node(i, j);
                     visit[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(sum != 0 ? sum : "TT");
    }
    static void bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(map[node.y][node.x] == 'P') sum++;
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 'X' || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.offer(new Node(ny, nx));
                
            }
        }
    }
    static class Node{
        int y, x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
