import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		for(int i = 0; i <= n / 3; i++) {
			int s = n - (i*3);
			if(s == 0) ans = ans > i ? i : ans;
			if(s % 5 == 0) {
				ans = ans > i + s / 5 ? i + s / 5 : ans;
			}	
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
}