import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp0 = new int[41];
        int[] dp1 = new int[41];
        dp0[0] = 1;
        dp0[1] = 0;
        dp0[2] = 1;
        dp1[1] = 1;
        dp1[2] = 1;
        for(int i = 3; i < 41; i++){
            dp0[i] = dp0[i - 2] + dp0[i - 1];
            dp1[i] = dp1[i - 2] + dp1[i - 1];
        }
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp0[n] + " " + dp1[n]);
        }
    }
}
