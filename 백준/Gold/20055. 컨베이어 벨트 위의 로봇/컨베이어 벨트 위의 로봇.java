import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tn = n * 2;
        int k = Integer.parseInt(st.nextToken());
        int[] belt = new int[tn + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= tn; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        boolean[] robot = new boolean[n + 1];
        int ans = 1;
        while(true){
            // 회전
            int tmp = belt[tn];
            for(int i = tn; i >= 2; i--){
                belt[i] = belt[i - 1];
            }
            belt[1] = tmp;
            
            for(int i = n - 1; i >= 2; i--){
                robot[i] = robot[i - 1];
            }
            robot[1] = false;
            
            // 이동
            for(int i = n; i >= 1; i--){
                int next = (i % tn) + 1;
                if(robot[i] && belt[next] > 0 && !robot[next]){
                    robot[i] = false;
                    robot[next] = true;
                    belt[next]--;
                    if(belt[next] == 0) cnt++;
                }
            }
            // 로봇 내림
            robot[n] = false;
            
            // 로봇 올리기
            if(belt[1] > 0) {
                robot[1] = true;
                belt[1]--;
                if(belt[1] == 0) cnt++;
            }
            if(cnt >= k) break;
            ans++;
        }
        System.out.println(ans);
    }
}
