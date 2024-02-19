import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] perm = new int[n];
		for(int i = 0; i < n; i++) {
			perm[i] = Integer.parseInt(st.nextToken());
		}
		int i = n - 1;
		while(i > 0 && perm[i] < perm[i-1]){
			--i;
		}
		if(i == 0) {
			System.out.println(-1);
			return;
		}
		int j = n - 1;
		while(perm[i-1] >= perm[j]) {
			--j;
		}
		swap(perm, i-1, j);
		int k = n - 1;
		while(i < k) {
			swap(perm, i++, k--);
		}
		for(int p : perm) {
			sb.append(p).append(" ");
		}
		System.out.println(sb);
	}
	static void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}