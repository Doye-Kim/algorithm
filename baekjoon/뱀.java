import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, k, l;
		int[][] board;
		int[][] apple; // 사과 위치
		int[] time; // 회전 시간
		char[] dir; // 회전 방향
		boolean end;
		
		try {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			k = Integer.parseInt(br.readLine());
			apple = new int[k][2];
			for(int i = 0; i < k; i++) {
				String[] a = br.readLine().split(" ");
				apple[i][0] = Integer.parseInt(a[0]);
				apple[i][1] = Integer.parseInt(a[1]);
			}
			l = Integer.parseInt(br.readLine());
			time = new int[l];
			dir = new char[l];
			for(int i = 0; i < l; i++) {
				String[] a = br.readLine().split(" ");
				time[i] = Integer.parseInt(a[0]);
				dir[i] = a[1].charAt(0);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
