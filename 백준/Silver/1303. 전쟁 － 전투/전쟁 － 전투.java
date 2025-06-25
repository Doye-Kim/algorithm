import java.util.*;
import java.io.*;

public class Main
{
    static int n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visit;
    static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visit = new boolean[m][n];
		for(int i = 0; i < m; i++){
		    String str = br.readLine();
		    for(int j = 0; j < n; j++){
		        map[i][j] = str.charAt(j);
		    }
		}
		int sumw = 0;
		int sumb = 0;
		for(int i = 0; i < m; i++){
		    for(int j = 0; j < n; j++){
		        if(visit[i][j]) continue;
		        if(map[i][j] == 'W') sumw += Math.pow(find(i, j, map[i][j]), 2);
		        if(map[i][j] == 'B') sumb += Math.pow(find(i, j, map[i][j]), 2);
		    }
		}
		System.out.print(sumw + " " + sumb);
	}
	static int find(int i, int j, char now){
	    ArrayDeque<Soldier> q = new ArrayDeque<>();
	    q.offer(new Soldier(i, j));
	    visit[i][j] = true;
	    int cnt = 1;
	    while(!q.isEmpty()){
	        Soldier soldier = q.poll();
	        int y = soldier.y;
	        int x = soldier.x;
    	    for(int d = 0; d < 4; d++){
    	        int ny = y + dy[d];
    	        int nx = x + dx[d];
    	        if(ny < 0 || nx < 0 || ny >= m || nx >= n 
    	            || visit[ny][nx] || map[ny][nx] != now) continue;
    	        q.offer(new Soldier(ny, nx));
    	        visit[ny][nx] = true;
    	        cnt++;
    	    }
	    }
	    return cnt;
	}
	
	static class Soldier{
	    int y, x;
	    public Soldier(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	}
}
