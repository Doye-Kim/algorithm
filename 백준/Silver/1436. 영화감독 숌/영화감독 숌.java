import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = 665;
		for(int i = 0; i < n; i++) {
			while(true) {
				start++;
				if(String.valueOf(start).contains("666")) break;
			}
		}
		System.out.println(start);
	}

}