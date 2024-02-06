import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int tmp = 0;
		if(m > n) {
			tmp = n;
			n = m;
			m = tmp;
		}
		int max = 0;
		for(int i = 1; i <= m; i++) {
			if(n % i == 0 && m % i == 0) max = i;
		}
		System.out.println(max);
		int min = n;
		while(true) {
			if(min % m == 0) break;
			min += n;
		}
		System.out.println(min);
	}
}