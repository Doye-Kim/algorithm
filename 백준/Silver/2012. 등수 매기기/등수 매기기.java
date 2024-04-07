import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] num, tmp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		//System.out.println(Arrays.toString(num));
		tmp = new int[N];
		sort(0, N-1);
		
		//System.out.println(Arrays.toString(num));
		long sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += Math.abs(num[i-1] - i);
		}
		System.out.println(sum);
	}
	static void merge(int left, int mid, int right) {

		int i = left; // 왼쪽 배열 시작점
		int r = mid + 1; // 오른쪽 배열 시작점
		int idx = left; // 정렬된 배열의 인덱스
		
		while(i <= mid && r <= right) {
			if(num[i] <= num[r]) tmp[idx++] = num[i++];
			else tmp[idx++] = num[r++];
		}
		
		// 왼쪽 배열이나 오른쪽 배열이 먼저 정렬되어 다른 한 배열이 남은 경우,
		// 해당하는 값들을 넣어줌
		while(i <= mid) tmp[idx++] = num[i++];
		while(r <= right) tmp[idx++] = num[r++];
		
		// 정렬된 배열을 원배열에 삽입
		for(i = left; i <= right; i++) {
			num[i] = tmp[i];
		}
	}
	static void sort(int start, int end) {
		if(start == end) return;
		int mid = (start + end) / 2;
		sort(start, mid);
		sort(mid + 1, end);
		merge(start, mid, end);
	}
}