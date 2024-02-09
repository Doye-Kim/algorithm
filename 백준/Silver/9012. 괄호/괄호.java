import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			Deque<Character> stack = new ArrayDeque<>();
			char[] ch = br.readLine().toCharArray();
			boolean vps = true;

			for(int j = 0; j < ch.length; j++) {
				if(ch[j] == '(') {
					stack.push('(');
				}
				if(ch[j] == ')') {
					if(stack.isEmpty()) {
						vps = false;
						break;
					}
					stack.pop();
				}
			}
			sb.append(vps && stack.isEmpty() ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}

}
