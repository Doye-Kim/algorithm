import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[Integer.parseInt(st.nextToken())] = i;
        }

        int max = 1;
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] > arr[i-1]) {
                if (++cnt > max)
                    max = cnt;
            } else {
                cnt = 1;
            }
        }
        System.out.println(n-max);
    }
}