import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// boj 1010
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			BigInteger answer = new BigInteger("1");
			for(int i = m; i > m-n; i--) {
				answer = answer.multiply(BigInteger.valueOf(i));
			}
			for(int i = n; i > 0; i--) {
				answer = answer.divide(BigInteger.valueOf(i));
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}