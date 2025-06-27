import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++){
		    String str = br.readLine();
		    for(int j = 0; j < n; j++){
		        map[i][j] = str.charAt(j);
		    }
		}
		int horizontal = 0;
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
		        if(visit[i][j] || map[i][j] == 'X') continue;
		        if(calc(i, j, 1) >= 2) horizontal++;
		    }
		}
		int vertical = 0;
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
		        if(visit[i][j] || map[i][j] == 'X') continue;
		        if(calc(i, j, 0) >= 2) vertical++;
		    }
		}
		System.out.print(horizontal + " " + vertical);
	}
	static int calc(int y, int x, int d){
	    int cnt = 1;
	    int ny = y;
	    int nx = x;
	    visit[ny][nx] = true;
	    while(true){
	        ny = ny + dy[d];
	        nx = nx + dx[d];
	        if(ny >= n || nx >= n || map[ny][nx] == 'X' || visit[ny][nx]) break;
	        cnt++;
	        visit[ny][nx] = true;
	    }
	    return cnt;
	}
}
