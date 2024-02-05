import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		int idx = 0;
		sb.append("<");
		while(!list.isEmpty()) {
			idx = (idx + (k - 1)) % list.size();
			sb.append(list.get(idx));
			if(list.size() == 1) sb.append(">");
			else sb.append(", ");
			list.remove(idx);
		}
		System.out.println(sb);
	}
}