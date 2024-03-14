import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, ans, btnCnt;
	static boolean[] btn;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		btnCnt = Integer.parseInt(br.readLine());
		btn = new boolean[10];
		ans = Integer.MAX_VALUE;
		Arrays.fill(btn, true);
		if(btnCnt != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < btnCnt; i++) {
				btn[Integer.parseInt(st.nextToken())] = false;
			}
		}
		ans = diff(N, 100);

		for(int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
					
			boolean isbreak = false;
			for(int j = 0; j < len; j++) {
				if(!btn[str.charAt(j) - '0']) {
					isbreak = true;
					break;
				}
			}
			if(!isbreak) {
				int min = diff(N, i) + len;
				ans = Math.min(min, ans);
			}
		}
		System.out.println(ans);
	}

	static int diff(int n1, int n2) {
		return Math.abs(n1 - n2);
	}

}