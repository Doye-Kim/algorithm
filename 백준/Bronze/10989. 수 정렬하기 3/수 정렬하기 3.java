import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] sorted;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] s = new int[n];
		for(int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(s);
		for(int i = 0; i < n; i++) {
			sb.append(s[i]).append("\n");
		}
		System.out.println(sb);
	}
}