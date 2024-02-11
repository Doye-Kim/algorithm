import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, b, min, max;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(min > map[i][j]) min = map[i][j];
				if(max < map[i][j]) max = map[i][j];
			}
		}
		int minTime, height = 0, time, inv;
		minTime = Integer.MAX_VALUE;
		if(max == min) {
			System.out.println(0 + " " + min);
			return;
		}
		for(int s = min; s <= max; s++) {
			time = 0;
			inv = b;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == s) continue;
					if(map[i][j] > s) {
						time += 2 * (map[i][j] - s);
						inv += map[i][j] - s;
					}
					if(map[i][j] < s) {
						time += (s - map[i][j]);
						inv -= (s - map[i][j]);
					}
				}
			}
			if(inv < 0) continue;
			if(minTime > time && time != 0) {
				minTime = time;
				height = s;
			}
			if(minTime == time) {
				if(height < s) height = s;
			}
		}
		System.out.println(minTime + " " + height);
		
	}
}
