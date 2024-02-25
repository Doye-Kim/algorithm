import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] can;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		while(input != null) {
			int n = Integer.parseInt(input);
			can = new char[(int)Math.pow(3, n)];
			for(int i = 0; i < can.length; i++) {
				can[i] = '-';
			}
			cantorian(0, can.length);
			sb.append(String.valueOf(can)).append("\n");
			input = br.readLine();
		}
		System.out.println(sb);

	}
	static void cantorian(int start, int size) {
		if(size == 1) return;
		size /= 3;
		for(int i = start + size; i < start + 2 * size; i++) {
			can[i] = ' ';
		}
		cantorian(start, size);
		cantorian(start + 2 * size, size);
		
	}

}