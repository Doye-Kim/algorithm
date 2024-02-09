import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<User> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new User(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}
	static class User implements Comparable<User>{
		int age,order;
		String name;

		public User(int order, int age, String name) {
			this.age = age;
			this.order = order;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}

		@Override
		public int compareTo(User o) {	
			return age == o.age ? order - o.order : age - o.age;
		}
		
	}
}