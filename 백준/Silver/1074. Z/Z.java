import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 2^N
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = 1 << N; // n*n 배열
		//int cnt = n*n;
		long start = 0;
		long range = 0;
		while(true) {
			n /= 2;
			//System.out.println("n" + n +" " + r + " " + c);
			if(n <= 0) break;
			range = 1 << (N * 2 - 2);

			if(r < n && c >= n) { // 2	
				//System.out.println(2);
				start += range;
			}
			if(r >= n && c < n) { // 3
				//System.out.println(3);
				start += range * 2;
			}
			if(r >= n && c >= n) { // 4
				//System.out.println(4);
				start += range * 3;
			}
			N--;
			r = r % n;
			c = c % n;
		}
		System.out.println(start);	
	}
}