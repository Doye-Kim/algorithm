import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new Node[N];
		long sum = 0, tmp = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			list[i] = new Node(x, a);
			sum += a;
		}
		sum = (sum + 1) / 2;
		Arrays.sort(list);
		for(int i = 0; i < N; i++) {
			tmp += list[i].a;
			if(tmp >= sum) {
				System.out.println(list[i].x);
				break;
			}
		}
	}

	static class Node implements Comparable<Node>{
		int x, a;

		public Node(int x, int a) {
			super();
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Node o) {
			return x - o.x;
		}
	}
}
