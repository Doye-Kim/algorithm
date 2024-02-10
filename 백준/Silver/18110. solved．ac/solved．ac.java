import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] opinion = new int[n];
		int m = (int) Math.round(n * 0.15);
		for(int i = 0; i < n; i++) {
			opinion[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(opinion);
		int sum = 0;
		for(int i = m; i < n - m; i++) {
			sum += opinion[i];
		}
		System.out.println(Math.round((double)sum / (n - (m*2))));
	}

}