import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] white = new int[101][101];
		for(int k = 0; k < n; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = x; i < x + 10; i++) {
				for(int j = y; j < y + 10; j++) {
					white[i][j] = 1;
				}
			}
		}
		int sum = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				sum += white[i][j];
			}
		}
		System.out.println(sum);
	}
}