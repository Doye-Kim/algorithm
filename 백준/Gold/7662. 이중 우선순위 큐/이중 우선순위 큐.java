import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minPQ = new PriorityQueue<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String id = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				// 삽입 
				if(id.equals("I")) {
					maxPQ.add(a);
					minPQ.add(a);
					map.put(a, map.getOrDefault(a, 0) + 1);
				}
				// 삭제 
				if(id.equals("D")) {
					if(map.isEmpty()) continue;
					if(a == -1) {
						removeQM(minPQ, map);
					}
					else if(a == 1) {
						removeQM(maxPQ, map);
					}
				}
			}
			if(map.isEmpty()) System.out.println("EMPTY");
			else {
                int max = removeQM(maxPQ, map);
                System.out.println(max + " " + (map.size() > 0 ? removeQM(minPQ, map) : max));
            }
		}
	}
	static int removeQM(PriorityQueue<Integer> q, HashMap<Integer, Integer> map) {
		int key = 0;

		while(true) {
			key = q.poll();
			int cnt = map.getOrDefault(key, 0);
			if(cnt == 0) continue;
			else if(cnt == 1) map.remove(key);
			else if(cnt > 1) map.put(key, map.get(key) - 1);
			break;
		}
		return key;
	}
}