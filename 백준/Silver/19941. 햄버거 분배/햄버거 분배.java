import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		
		// 안 먹은 햄버거는 0, 먹은 햄버거는 1, 사람은 2
		int[] hp = new int[n];
		
		String str = br.readLine();
		for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'H') hp[i] = 0;
            else hp[i] = 2;
		}
		int cnt = 0;
		for(int i = 0; i < n; i++){
            if(hp[i] == 2){
                for(int j = i - k; j <= i + k; j++){
                    if(j < 0 || j >= n) continue;
                    if(hp[j] == 0) {
                        hp[j] = 1;
                        cnt++;
                        break;
                    }
                }
            }
		}
		System.out.print(cnt);
	}
}
