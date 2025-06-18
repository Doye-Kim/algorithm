import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] a = new int[k + 1];
		int[] b = new int[k + 1];
		a[0] = 1;
		for(int i = 1; i <= k; i++){
		    a[i] = b[i - 1];
		    b[i] = a[i - 1] + b[i - 1];
		}
		System.out.print(a[k] + " " +b[k]);
	}
}
