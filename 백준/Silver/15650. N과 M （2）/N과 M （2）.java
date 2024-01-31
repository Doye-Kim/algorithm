import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[] tgt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		tgt = new int[m];
		comb(0,0);
		System.out.println(sb);
	}
	static void comb(int idx, int tgtIdx) {
		if(tgtIdx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = idx; i < n; i++) {
			tgt[tgtIdx] = i + 1;
			comb(i + 1, tgtIdx + 1);
		}
	}
}