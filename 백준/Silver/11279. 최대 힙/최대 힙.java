import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                if(pq.size() == 0) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else pq.add(now);
        }
        System.out.println(sb);
    }
}
