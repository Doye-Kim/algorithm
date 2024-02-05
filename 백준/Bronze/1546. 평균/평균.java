import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] scores = new double[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			if(max < scores[i]) max = (int)scores[i];
		}
		double sum = 0;
		for(int i = 0; i < n; i++) {
			scores[i] = scores[i] / (double)max * 100.0;
			sum += scores[i];
		}
		System.out.println(sum / n);
		
	}

}