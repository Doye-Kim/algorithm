import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger num = BigInteger.ONE;
		for(int i = n; i > 0; i--) {
			num = num.multiply(BigInteger.valueOf(i));
		}
		String s = String.valueOf(num);
		int cnt = 0;
		boolean zero = false;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(zero && s.charAt(i) != '0') break;
			if(s.charAt(i) == '0') {
				zero = true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}