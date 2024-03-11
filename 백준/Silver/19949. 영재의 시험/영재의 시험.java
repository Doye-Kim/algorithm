import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] src = {1, 2, 3, 4, 5};
	static int[] tgt, answer;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = new int[10];
		tgt = new int[10];
		for(int i = 0; i < 10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(cnt);
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == 10) {
			int ans = 0;
			for(int i = 0; i < 10; i++) {
				if(tgt[i] == answer[i]) ans++;
				if(ans >= 5) {
					cnt++;
					break;
				}
			}
			return;
		}
		for(int i = 0; i < 5; i++) {
			if(tgtIdx >= 2 && src[i] == tgt[tgtIdx-1] && src[i] == tgt[tgtIdx-2]) continue;
			tgt[tgtIdx] = src[i];
			perm(tgtIdx + 1);
		}
	}
}
