import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] cnt = new int[100001];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        long ans = 0;
        while(l < n){
            while(r < n && cnt[num[r]] == 0){
                cnt[num[r++]]++;
            }
            ans += r - l;
            cnt[num[l++]]--;
        }
        System.out.println(ans);
    }
}
