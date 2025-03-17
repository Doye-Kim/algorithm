import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] num;
    static boolean[] visit;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1; i <= n; i++){
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int start, int target){
        int now = num[start];
        if(!visit[now]){
            visit[now] = true;
            dfs(now, target);
            visit[now] = false;
        }
        if(now == target){
            list.add(target);
        }
    }
}
