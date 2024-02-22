import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		int k = Integer.parseInt(br.readLine()) - 1;
		int[] ws = new int[V];
		ArrayList<Node>[] list = new ArrayList[V];
		for(int i = 0; i < V; i++){
            list[i] = new ArrayList<>();
        }

		Arrays.fill(ws, Integer.MAX_VALUE);

		for(int i = 0; i < E; i++) {
			String[] tmp = br.readLine().split(" ");
			int u = Integer.parseInt(tmp[0]) - 1;
			int v = Integer.parseInt(tmp[1]) - 1;
			int w = Integer.parseInt(tmp[2]);
			list[u].add(new Node(v, w));
		}
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] isVisited = new boolean[V];
		q.add(new Node(k, 0));
		ws[k] = 0;
		while(!q.isEmpty()) {
			Node cn = q.poll();
			int cur = cn.end;
			
			if(isVisited[cur]) continue;
			isVisited[cur] = true;
			for(Node node: list[cur]) {
				if(ws[node.end] > ws[cur] + node.weight) {
					ws[node.end] = ws[cur] + node.weight;
					q.add(new Node(node.end, ws[node.end]));
				}
			}
		}
		for(int i = 0; i < V; i++) {
			if(ws[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(ws[i]);
		}
		
	}

}
