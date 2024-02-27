import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static ArrayList<ArrayList<Person>> list;
	static int[] ans;
	static int[] minWeight;
	static ArrayList<Integer> answer;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			minWeight = new int[m];
			Arrays.fill(minWeight, Integer.MAX_VALUE);
			answer = new ArrayList<>();
			list = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				list.add(new ArrayList<>());
			}
			ans = new int[m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				list.get(x).add(new Person(y, z));
				list.get(y).add(new Person(x, z));
			}
			dijk(0);
			sb.append("Case #").append(t).append(": ");
//			System.out.println(minWeight[m-1]);
			if(minWeight[m-1] == Integer.MAX_VALUE) sb.append(-1);
			else{
				searchPath();
			}
		}
		System.out.print(sb);
	}
	static void searchPath() {
		Deque<Integer> stack = new ArrayDeque<>();
		int cur = m-1;
		while(cur != 0) {
			stack.push(cur);
			cur = ans[cur];
		}
		stack.push(cur);
		while(!stack.isEmpty()) {
			sb.append(stack.poll()).append(" ");
		}
		sb.append("\n");
	}
	static void dijk(int start) {
		PriorityQueue<Person> pq = new PriorityQueue<>((n1, n2) -> n1.z - n2.z);
		pq.offer(new Person(start, 0));
		minWeight[start] = 0;
		while(!pq.isEmpty()) {
			Person person = pq.poll();
			int x = person.y;
			for(Person p : list.get(x)) {
				if(minWeight[p.y] > minWeight[x] + p.z) {
					minWeight[p.y] = minWeight[x] + p.z;
					pq.offer(new Person(p.y, minWeight[p.y]));
					ans[p.y] = x;
//					System.out.println(Arrays.toString(ans));
				}
			}
		}
	}
	static class Person{
		int y, z;

		public Person(int y, int z) {
			this.y = y;
			this.z = z;
		}
	}
}