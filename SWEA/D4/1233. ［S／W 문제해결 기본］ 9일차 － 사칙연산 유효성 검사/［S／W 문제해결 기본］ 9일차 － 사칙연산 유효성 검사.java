import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			boolean isVariable = true;
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			char[] tree = new char[n + 1];
			for(int i = 1; i <= n; i++) {
				String[] a = br.readLine().split(" ");
				tree[i] = a[1].charAt(0);
			}
			for(int i = 1; i <= n; i++) {
				if((i * 2 + 1 <= n && Character.isDigit(tree[i])) || (i * 2 + 1 > n && !Character.isDigit(tree[i]))) {
					isVariable = false;
					break;
				}
			}
			if(isVariable) sb.append(1).append("\n");
			else sb.append(0).append("\n");	
		}
		System.out.println(sb);
	}
}