import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] buildings = new int[n];
	    for(int i = 0; i < n; i++){
	        buildings[i] = Integer.parseInt(st.nextToken());
	    }
	    int answer = 0;
	    for(int i = 0; i < n; i++){
	        int cnt = 0;
	        double tmp = 0;
	        for (int j = i - 1; j >= 0; j--) {
                double m = (double) (buildings[i] - buildings[j]) / (i - j);
               
                if (j == i - 1 || tmp > m) {
                    cnt++;
                    tmp = m;
                }
            }
            for (int j = i + 1; j < n; j++) {
                double m = (double) (buildings[i] - buildings[j]) / (i - j);
               
                if (j == i + 1 || tmp < m) {
                    cnt++;
                    tmp = m;
                }
            }
	        answer = Math.max(answer, cnt);
	    }
	    System.out.println(answer);
	}
}
