import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] as = new int[n][2];
		int cnt = 1 << n;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			as[i][0]= Integer.parseInt(st.nextToken());
			as[i][1]= Integer.parseInt(st.nextToken());
		}
		int sour, bitter;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < cnt; i++) {
			sour = 1;
			bitter = 0;
			for(int j = 0; j < n; j++) {
				if((i & 1 << j) != 0) {
					sour *= as[j][0];
					bitter += as[j][1];
				}
			}
			//System.out.println(sour + " " + bitter);
			min = min > Math.abs(sour - bitter) ? Math.abs(sour - bitter) : min;
		}
		System.out.println(min);
		
	}

}