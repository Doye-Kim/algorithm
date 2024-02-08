import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, midX, midY;
	static int[] xs, ys;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().split(" ")[0]);
		xs = new int[n];
		ys = new int[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xs[i] = x;
			ys[i] = y;
		}
		Arrays.sort(xs);
		Arrays.sort(ys);
		midX = xs[n / 2];
		midY = ys[n / 2];
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Math.abs(xs[i] - midX) + Math.abs(ys[i] - midY);
		}
		System.out.println(sum);
		
	}

}
