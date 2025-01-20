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
        binarySearch(0, trees[n-1], trees[n-1] / 2);
        System.out.println(ans);
    }
    static int binarySearch(int start, int end, int mid){
        if(start >= mid) return 0;
        if(isCutEnough(mid)) {
            ans = Math.max(ans, mid);
            return binarySearch(mid, end, (mid + end) / 2);
        }
        else return binarySearch(start, mid, (start + mid) / 2);
    }
    
    static boolean isCutEnough(int height){
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(trees[i] - height > 0) sum += trees[i] - height;
        }
        if(sum >= m) return true;
        else return false;
    }
}
