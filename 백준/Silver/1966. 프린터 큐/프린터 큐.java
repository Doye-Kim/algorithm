import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Integer[] docs = new Integer[n];
			ArrayList<Integer> arr = new ArrayList<>();
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Deque<Node> q = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				docs[i] = Integer.parseInt(st.nextToken());
				q.offer(new Node(i, docs[i]));
			}
			Arrays.sort(docs, Collections.reverseOrder());
			int idx = 0;
			int cnt = 1;
			while(idx < n) {
				if(q.peek().value == docs[idx]) {
					if(q.peek().index == m) break;
					q.poll();
					idx++;
					cnt++;
				}
				else {
					Node re = q.poll();
					q.add(re);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}
	static class Node{
		int index, value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}