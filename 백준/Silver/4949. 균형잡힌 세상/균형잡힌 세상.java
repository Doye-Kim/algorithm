import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			char[] str = br.readLine().toCharArray();
			Deque<Character> stack = new ArrayDeque<>();
			String ans = "yes";
			if(str.length == 1 && str[0] == '.') break; 
			for(int i = 0; i < str.length; i++) {
				if(str[i] == '(' || str[i] == '[') {
					stack.push(str[i]);
				}
				if(str[i] == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
					else {
						ans = "no";
						break;
					}
				}
				if(str[i] == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
					else {
						ans = "no";
						break;
					}
				}
			}
			if(!stack.isEmpty()) ans = "no";
			sb.append(ans).append("\n");			
		}
		System.out.println(sb);
	}
}