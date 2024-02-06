import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = 1;
		int cnt = 1;
		while(n > k) {
			k += (6 * cnt);
			cnt++;
		}
		System.out.println(cnt);
	}

}