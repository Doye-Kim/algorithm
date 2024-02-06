import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] sorted;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		sorted = new int[N];
		merge_sort(num, 0, N - 1);
		for(int i = 0; i < N; i++) {
			sb.append(num[i]).append("\n");
		}
		System.out.println(sb);
	}
	static void merge_sort(int[] a, int left, int right) {
		for(int size = 1; size <= right; size += size) {
			for(int l = 0; l <= right - size; l += (2 * size)) {
				int low = l;
				int mid = l + size - 1;
				int high = Math.min(l  + (2 * size) - 1, right);
				merge(a, low, mid, high);
			}
		}
	}
	static void merge(int[] a, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(a[l] <= a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}
		else {
			while(l <= mid) {
				sorted[idx] = a[l];
				idx++;
				l++;
			}
		}
		for(int i = left; i <= right; i++) {
			a[i] = sorted[i];
		}
	}
}
