import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		int n = s.length;
		int zero = 0, one = 0;
		for(int i = 0; i < n; i++){
		    if(s[i] == '0') zero++;
		    else one++;
		}
		int zc = zero / 2;
		int oc = one / 2;
		// 앞에서부터 1을 없애고, 뒤에서부터 0을 없앤다.
		for(int i = 0; i < n; i++){
		    if(one == oc) break;
		    if(s[i] == '1') {
		        s[i] = '2';
		        one--;
		    }
		}
		for(int i = n - 1; i >= 0; i--){
		    if(zero == zc) break;
		    if(s[i] == '0') {
		        s[i] = '2';
		        zero--;
		    }
		}
		
		for(int i = 0; i < n; i++){
		    if(s[i] != '2') System.out.print(s[i]);
		}
	}
}
