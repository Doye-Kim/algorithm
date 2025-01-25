import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.copyOf(num, n);
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int value : sorted) {
            if (!map.containsKey(value)) {
                map.put(value, idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : num) {
            sb.append(map.get(value)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
