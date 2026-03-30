import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for(int i = 0; i < n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < m; j++){
		        a[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] b = new int[m][k];
		for(int i = 0; i < m; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0; j < k; j++){
		        b[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x < n; x++){
            for(int z = 0; z < k; z++){
                int sum = 0;
		        for(int y = 0; y < m; y++){
		            sum += a[x][y] * b[y][z];
		        }
		        sb.append(sum + " ");
		    }
		    sb.deleteCharAt(sb.length() - 1);
		    sb.append("\n");
		}
		System.out.print(sb);
	}
}
