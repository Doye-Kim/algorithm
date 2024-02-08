import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> st = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			String[] order = br.readLine().split(" ");
			switch(order[0]) {
			case "push":
				st.push(Integer.parseInt(order[1]));
				break;
			case "pop":
				if(st.isEmpty()) sb.append(-1).append("\n");
				else sb.append(st.pop()).append("\n");
				break;
			case "size":
				sb.append(st.size()).append("\n");
				break;
			case "empty":
				sb.append(st.isEmpty() ? 1 : 0).append("\n");
				break;
			case "top":
				if(st.isEmpty()) sb.append(-1).append("\n");
				else sb.append(st.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}