import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans = Integer.MAX_VALUE;
	static HashMap<Integer, Integer> move = new HashMap<>();
	static int visit[] = new int[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			move.put(x, y);
		}
		PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> visit[n1] - visit[n2]);
		q.offer(1);
		visit[1] = 0;
		while(!q.isEmpty()) {
			int n = q.poll();
			//System.out.println(n);
			if(n == 100) {
				ans = Math.min(visit[n], ans);
			}
			if(move.containsKey(n)) {
				q.offer(move.get(n));
				visit[move.get(n)] = visit[n];
				continue;
			}
			for(int i = 1; i <= 6; i++) {
				if(n+i > 100 || visit[n+i] > 0) continue;
				visit[n+i] = visit[n] + 1;
				q.offer(n+i);
			}
		}
		//System.out.println(Arrays.toString(visit));
		System.out.println(ans);
	}
}