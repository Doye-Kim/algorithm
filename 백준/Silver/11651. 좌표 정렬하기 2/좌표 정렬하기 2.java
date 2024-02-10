import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Point(x, y));
		}
		while(!pq.isEmpty()) {
			Point pos = pq.poll();
			sb.append(pos.x).append(" ").append(pos.y).append("\n");
		}
		System.out.println(sb);
	}
	static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return y == o.y ? x - o.x : y - o.y;
		}
		
	}

}
