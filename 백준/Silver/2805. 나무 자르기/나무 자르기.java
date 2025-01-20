import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i = 0; i < N; i ++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int left = 0;
        int right = max;

        while(left < right) {
            int mid = (right + left) / 2;
            long length = 0;

            for(int tree_len : tree) {
                if(tree_len - mid > 0) length += tree_len - mid;
            }

            if(length >= M) left = mid + 1;
            else right = mid;
        }

        System.out.println(left - 1);
    }
}