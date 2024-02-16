import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, v;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[to][from] = 1;
			graph[from][to] = 1;
		}
		visited[v] = true;
		dfs(v);
		sb.append("\n");
		visited = new boolean[n+1];
		bfs();
		System.out.println(sb);
	}
	static void dfs(int start) {
		sb.append(start).append(" ");
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && graph[start][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
		return;
	}
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		sb.append(v).append(" ");
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && graph[now][i] == 1) {
					visited[i] = true;
					q.offer(i);
					sb.append(i).append(" ");
				}
			}
		}
	}
}