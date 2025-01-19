import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] num;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < n; r++){
            map.put(num[r], map.getOrDefault(num[r], 0) + 1);
            while(map.size() > 2){
                map.put(num[l], map.get(num[l]) - 1);
                if(map.get(num[l]) == 0) map.remove(num[l]);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
