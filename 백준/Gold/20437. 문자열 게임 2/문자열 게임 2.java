import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if(k == 1){
                sb.append("1 1").append("\n");
                continue;
            }
            int[] alpha = new int[26];
            for(int i = 0; i < w.length(); i++){
                alpha[w.charAt(i) - 'a']++;
            }
            int min = 10001;
            int max = 0;
            for(int l = 0; l < w.length(); l++){
                if(alpha[w.charAt(l) - 'a'] < k) continue;
                int cnt = 1;
                
                for(int r = l + 1; r < w.length(); r++){
                    if(w.charAt(l) == w.charAt(r)) cnt++;
                    if(cnt == k){
                        min = Math.min(min, r - l + 1);
                        max = Math.max(max, r - l + 1);
                        break;
                    }
                }
            }
            if(min == 10001) sb.append("-1").append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
