import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] numbers = new Integer[n];
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers, (n1, n2) -> n1 < 0  && n2 < 0 ? n2 - n1 : n1 - n2);
		//System.out.println(Arrays.toString(numbers));
		int sum = 0;
		for(int i = n-1; i > 0; i--) {
			//System.out.println("S" + sum);
			if(numbers[i] == 0) {
				if(i > 1 && (i % 2 == 0 || numbers[i-1] == 0)) continue;
				else {
					//System.out.println(i + " " + numbers[i]  +" " + numbers[0]);
					sum += numbers[i] * numbers[0];
					//System.out.println(sum);
					numbers[0] = 0;
					continue;
				}
			}
			else if(numbers[i-1] == 0) {
				sum += numbers[i];
				continue;
			}
			int now = numbers[i] * numbers[i-1] > numbers[i] + numbers[i-1] ? numbers[i] * numbers[i-1] : numbers[i] + numbers[i-1]; 
			if((i > 1) && (numbers[i-1] * numbers[i-2] > now || numbers[i-1] + numbers[i-2] > now)) {
				sum += numbers[i];
				continue;
			}
			else {
				//System.out.println("now " + now);
				sum += now;
				i--;
				if(i == 1) sum += numbers[0];
			}
		}
		if(n == 1)	sum += numbers[0];
		System.out.println(sum);

	}

}