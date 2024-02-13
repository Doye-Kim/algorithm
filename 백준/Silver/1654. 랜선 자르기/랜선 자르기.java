import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int k, n;

		k = sc.nextInt();
		n = sc.nextInt();
		
		int[] kLength = new int[k];
		
		long max = 0;
		for(int i = 0; i < k; i++) {
			kLength[i] = sc.nextInt();
			if(max < kLength[i]) {
				max = kLength[i];
			}
		}
        max++;
		long min = 0;
		//mid는 자르는 길이 
		long mid = 0;
		
		while(min < max) {
			mid = (long)(min + max) / 2;
			long cnt = 0;

			for(int i = 0; i < k; i++) {
				cnt += (kLength[i] / mid);
			}
			//System.out.println("mid = " + mid + " max = " + max + " min = " + min + " cnt = " + cnt);
			if(cnt < n) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}