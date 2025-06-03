import java.util.*;
import java.io.*;

public class Main
{
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < m; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int max = 0;
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < m; j++){
		        if(map[i][j] == 1) continue;
		        max = Math.max(max, bfs(i, j));
		    }
		}
		System.out.print(max);
	}
	static int bfs(int y, int x){
	    visit = new boolean[n][m];
	    ArrayDeque<Node> q = new ArrayDeque<>();
	    q.offer(new Node(y, x, 1));
	    visit[y][x] = true;
	    int min = 50;
	    while(!q.isEmpty()){
	        Node node = q.poll();
	        for(int d = 0; d < 8; d++){
	            int ny = node.y + dy[d];
	            int nx = node.x + dx[d];
	            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) continue;
	            if(map[ny][nx] == 1) {
	                min = Math.min(min, node.c);
	            }
	            else {
	                q.offer(new Node(ny, nx, node.c + 1));
	                visit[ny][nx] = true;
	            }
	        }
	    }
	    return min;
	}
	
	static class Node{
	    int y, x, c;
	    public Node(int y, int x, int c){
	        this.y = y;
	        this.x = x;
	        this.c = c;
	    }
	}
}
