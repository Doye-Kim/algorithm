import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);
			sum += num[i];
		}
		String s = String.format("%.0f", (double)sum / n).equals("-0") ? "0" : String.format("%.0f", (double)sum / n);
		sb.append(s).append("\n");
		Arrays.sort(num);
		sb.append(num[n / 2] +"\n");
		ArrayList<Integer> list = new ArrayList<>();
		int max = num[0];
		for(int key : map.keySet()) {
			if(map.get(key) > map.get(max)) {
				max = key;
				list.clear();
				list.add(key);
			}
			if(map.get(key) == map.get(max)) {
				list.add(key);
			}
		}
		if(list.size() == 1) sb.append(max).append("\n");
		else {
			Collections.sort(list);
			sb.append(list.get(1)).append("\n");
		}
		sb.append(num[n - 1] - num[0]).append("\n");
		System.out.println(sb);
	}

}
