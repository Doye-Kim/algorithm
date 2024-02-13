import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] exp = br.readLine().toCharArray();
		// 주어진 연산자가 한 개이거나 모두 같으면 괄호 의미 없음
		// 연산자가 나올 때까지를 저장해뒀다가 정수로 바꿈 <= 더 쉬운 거 없나
		// - 뒤나 -와 - 사이의 + 들을 묶어야 최소가 나오지 않을까
		// 그냥 순서대로 계산하면서 어쩌구 하면 됨
		int start = -1, idx = 0; // 숫자 시작 지점, 숫자 인덱스
		int[] num = new int[5];
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Character> opers = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		for (int i = 0; i < exp.length + 1; i++) {
			if(i == exp.length || !Character.isDigit(exp[i]) ) {
				int now = 0;
				for(int j = 0, t = i - start - 1; j < i - start; j++, t--) {
					now += num[j] * Math.pow(10, t);
				}
				numbers.add(now);
				if(i != exp.length) opers.add(exp[i]);
				start = -1;
				idx = 0;
			}
			else if(Character.isDigit(exp[i])) {
				num[idx++] = exp[i] - '0';
				if(start == -1) start = i;
			}
		}
		int s = numbers.get(0);
		boolean mi = false;
		for(int i = 0; i < opers.size();i++) {
			if(opers.get(i) == '-') mi = true;
			if(!mi) s = s + numbers.get(i+1);
			else if(mi) s = s - numbers.get(i+1);
		}
		System.out.println(s);
	}
}
