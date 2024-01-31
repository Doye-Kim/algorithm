import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] tgt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
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