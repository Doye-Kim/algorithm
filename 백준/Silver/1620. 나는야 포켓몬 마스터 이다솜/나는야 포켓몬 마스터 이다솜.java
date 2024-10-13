import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(i+1, str);
			map2.put(str, i+1);
		}
		for(int i = 0; i < M; i++) {
			String now = br.readLine();
			if(Character.isDigit(now.charAt(0))) {
				sb.append(map.get(Integer.parseInt(now))).append("\n");
			}
			else {
				sb.append(map2.get(now)).append("\n");
			}
		}
		System.out.println(sb);

	}

}
