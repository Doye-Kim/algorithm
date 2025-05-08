import java.util.*;
import java.io.*;
public class Main
{
    static int[][] map;
    static int n, m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 1; j <= m; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int z = 0; z < k; z++){
		    st = new StringTokenizer(br.readLine());
		    int i = Integer.parseInt(st.nextToken());
		    int j = Integer.parseInt(st.nextToken());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    sb.append(calc(i, j, x, y)).append("\n");
		}
		System.out.print(sb);
	}
	static int calc(int i, int j, int x, int y){
	    int sum = 0;
	    for(int k = i; k <= x; k++){
		    for(int z = j; z <= y; z++){
		        sum += map[k][z];
		    }
		}
	    return sum;
	}
}
