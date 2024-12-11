import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] result;
    static int n, m, ey, ex;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    ey = i;
                    ex = j;
                } else if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        bfs(ey, ex);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int y, int x) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        result[ny][nx] = result[node.y][node.x] + 1;
                        queue.add(new Node(ny, nx));
                    }
                }
            }
        }
    }
    static class Node {
        int x, y;
    
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}