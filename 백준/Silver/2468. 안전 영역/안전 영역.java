import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt, maxCnt = 0;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxHeight = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        for(int h = 0; h <= maxHeight; h++){
            visit = new boolean[n][n];
            cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visit[i][j] && map[i][j] > h) {
                        bfs(h, i, j);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.print(maxCnt);
	}
	static void bfs(int height, int y, int x){
	    ArrayDeque<Node> q = new ArrayDeque<>();
	    q.offer(new Node(y, x));
	    while(!q.isEmpty()){
	        Node node = q.poll();
	        for(int d = 0; d < 4; d++){
	            int ny = node.y + dy[d];
	            int nx = node.x + dx[d];
	            if(ny < 0 || ny >= n || nx < 0 || nx >= n || visit[ny][nx] || map[ny][nx] <= height) continue;
	            q.offer(new Node(ny, nx));
	            visit[ny][nx] = true;
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