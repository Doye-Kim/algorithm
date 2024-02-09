import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	// 96 빼기
	static int r = 31;
	static BigInteger M = new BigInteger("1234567891");
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		BigInteger sum = new BigInteger("0");
		for(int i = 0; i < ch.length; i++) {
			sum = sum.add(BigInteger.valueOf((long) (Math.pow(r, i) * ((int)ch[i] - 96))));
		}
		System.out.println(sum.remainder(M));

	}

}