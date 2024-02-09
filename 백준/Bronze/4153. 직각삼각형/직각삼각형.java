import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double[] t= new double[3];
			t[0] = Integer.parseInt(st.nextToken());
			t[1] = Integer.parseInt(st.nextToken());
			t[2] = Integer.parseInt(st.nextToken());
			if(t[0] == 0 && t[1] == 0 && t[2] == 0) break;
			Arrays.sort(t);
			if(Math.pow(t[0], 2) + Math.pow(t[1],2) == Math.pow(t[2], 2)) sb.append("right").append("\n");
			else sb.append("wrong").append("\n");
		}
		System.out.println(sb);
	}

}