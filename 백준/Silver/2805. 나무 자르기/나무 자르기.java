import java.util.*;
import java.io.*;

public class Main {
    static int n, m, ans = 0;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        trees = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        binarySearch(0, trees[n-1]);
        System.out.println(ans);
    }
    static void binarySearch(int start, int end){
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (isCutEnough(mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    
    static boolean isCutEnough(int height){
        long sum = 0;
        for(int i = n - 1; i >= 0; i--){
            if(trees[i] <= height) break;
            sum += trees[i] - height;
            if(sum >= m) return true;
        }
        return false;
    }
}
