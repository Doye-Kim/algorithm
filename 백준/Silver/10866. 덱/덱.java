import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

	public class Main {

		public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				String[] order = br.readLine().split(" ");
				switch(order[0]) {
				case "push_front":
					dq.addFirst(Integer.parseInt(order[1]));
					break;
				case "push_back":
					dq.addLast(Integer.parseInt(order[1]));
					break;
				case "pop_front":
					sb.append(dq.peekFirst() == null ? -1 : dq.pollFirst()).append("\n");
					break;
				case "pop_back":
					sb.append(dq.peekLast() == null ? -1 : dq.pollLast()).append("\n");
					break;
				case "size":
					sb.append(dq.size()).append("\n");
					break;
				case "empty":
					sb.append(dq.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					sb.append(dq.peekFirst() == null ? -1 : dq.peekFirst()).append("\n");
					break;
				case "back":
					sb.append(dq.peekLast() == null ? -1 : dq.peekLast()).append("\n");
					break;
				}
			}
			System.out.println(sb);
		}
	}

