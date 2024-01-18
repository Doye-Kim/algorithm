import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    // input
		char[] pp = bf.readLine().toCharArray();
		int SIZE = 4;
		char[] pen = {'P', 'P', 'A', 'P'};
		char[] tmp = new char[SIZE];
		Stack<Character> st = new Stack<>();

    // 구현
		for(char p : pp) {
			st.add(p);
			boolean isPPAP = true;
			if(st.size() >= SIZE) {
				//System.out.println(st);
				for(int j = SIZE - 1; j >= 0; j--) {
					tmp[j] = st.pop();
				}
				for(int i = 0; i < SIZE; i++) {
					if(tmp[i] != pen[i]) isPPAP = false;
				}
				//System.out.println(tmp);
				if(isPPAP) {
					st.push('P');
				}
				else {
					for(char t : tmp) {
						st.push(t);
					}
				}
			}
		}
		if(st.pop() == 'P' && st.isEmpty()) System.out.println("PPAP");
		else System.out.println("NP");
	}
}
