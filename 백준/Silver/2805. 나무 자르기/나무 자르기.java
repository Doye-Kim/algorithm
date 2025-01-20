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
        int max = 0;
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        
        binarySearch(0, max);
        System.out.println(ans);
    }
    static void binarySearch(int start, int end){
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (isCutEnough(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        ans = start - 1;
    }
    
    static boolean isCutEnough(int height){
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(trees[i] > height) sum += trees[i] - height;
        }
        if(sum >= m) return true;
        else return false;
    }
}
