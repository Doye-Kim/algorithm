import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isVisited;
	static boolean[] select;
	static int n; // 구역의 개수
	static int sum; // 전체 인구 수
	static int[] peoples; // 각 구역의 인구 수
	static int[][] con; // 인접 행렬
	static int min, cnt, COUNT; 
	
	public static void main(String[] args) throws Exception {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		peoples = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
			sum += peoples[i];
		}
		con = new int[n + 1][n + 1];

		COUNT = 1 << n;
		boolean isConnect = false;
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			int cnt = Integer.parseInt(s[0]);
			if(cnt != 0) isConnect = true;
			for(int j = 1; j <= cnt; j++) {
				con[i][Integer.parseInt(s[j])] = 1;
			}
		}
		if(!isConnect && n != 2) min = -1;
		else if(!isConnect && n == 2) min = Math.abs(peoples[1] - peoples[2]);
		else {
			min = Integer.MAX_VALUE;
			findPart();
		}
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	// 부분 조합 찾기
	static void findPart() {
		for(int i = 0; i < COUNT; i++) {
			select = new boolean[n + 1];
			isVisited = new boolean[n+1];
			for(int j = 0; j < n; j++) {
				if((i & 1 << j) != 0) select[j+1] = true;
			}
			int s = 0;
			int x1 = 0, x2 = 0;
			for(int x = 1; x <= n; x++) {
				if(x1 != 0 && x2 != 0) break;
				if(select[x]) x1 = x;
				else x2 = x;
	 		}
			cnt = 0;
			bfs(x1);
			if(cnt == 0 || cnt == n) continue;
			isVisited = new boolean[n+1];
			bfs(x2);
			if(cnt == n) {
				for(int x = 1; x <= n; x++) {
					if(select[x]) {s += peoples[x];
					}
				}
				if(Math.abs((sum - s) - s) < min) min = Math.abs((sum - s) - s);
			};

		}
	}
	// 연결 확인
	static void bfs(int x) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		isVisited[x] = true;
		cnt++;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i <= n; i++ ) {
				if(isVisited[i] || con[now][i] == 0 || select[i] != select[x]) continue;
				q.offer(i);
				isVisited[i] = true;
				cnt++;
			}
		}
	}
}