import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 보석: 무게순으로 오름차순 정렬, 무게가 같을 경우 가격을 내림차순 정렬
		// 가방: 오름차순 정렬
		ArrayList<Jewel> jewels = new ArrayList<>();
		int[] bags = new int[k];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Collections.sort(jewels);
		Arrays.sort(bags);

		// 가방에 넣을 수 있는 보석 정보가 들어갈 pq 는 가격 기준 내림차순 정렬
		PriorityQueue<Jewel> pq = new PriorityQueue<>((j1, j2) -> j2.price - j1.price);
		long sum = 0;

		int j = 0;
		
		// 가방별로 넣을 수 있는 보석들을 PQ에 넣은 후
		// 정렬되어 가격이 가장 비싼 것을 최종 값에 더한다.
		// 각 단계별로 넣기 때문에 이전에 들어갔던 것도 포함되고, j를 밖에 선언해 중복이 없으며
		// 하나씩만 뽑기 때문에 값이 이상해지지도 않음
		for(int i = 0; i < k; i++) {
			while(j < n && jewels.get(j).weight <= bags[i]) {
				pq.add(jewels.get(j++));
			}
			if (!pq.isEmpty()) {
                sum += pq.poll().price;
            }
		}

		System.out.println(sum);
	}
	static class Jewel implements Comparable<Jewel>{
		int weight, price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel o) {
			return  weight == o.weight ? o.price - price : weight - o.weight;
		}
	}
}