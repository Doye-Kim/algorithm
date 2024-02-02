import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int n;
	static PriorityQueue<Integer> cards;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cards = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			cards.offer(Integer.parseInt(br.readLine()));
		}
		System.out.println(calc());
	}
	static int calc() {
		if(cards.size() == 1) return 0;
		int part = 0;
		int sum = 0;
		while(cards.size() > 1) {
			part = 0;
			for(int i = 0; i < 2; i++) {
				part += cards.poll();
			}
			cards.offer(part);
			sum += part;
		}
		return sum;
	}
}
