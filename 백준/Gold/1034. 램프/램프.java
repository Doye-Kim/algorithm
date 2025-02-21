import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] lamp = new int[n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                lamp[i][j] = str.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++){
            int zeroCnt = 0;
            for(int j = 0; j < m; j++){
                if(lamp[i][j] == 0) zeroCnt++;
            }
            int samePattern = 0;
            if(zeroCnt <= k && zeroCnt % 2 == k % 2){
                for(int j = 0; j < n; j++){
                    if(isSame(lamp[i], lamp[j])) samePattern++;
                }
            }
            ans = Math.max(ans, samePattern);
        }
		System.out.println(ans);
    }
    static boolean isSame(int[] lamp1, int[] lamp2){
        for(int i = 0; i < m; i++){
            if(lamp1[i] != lamp2[i]) return false;
        }
        return true;
    }
}
