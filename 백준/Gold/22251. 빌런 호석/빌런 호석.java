import java.util.*;
import java.io.*;

public class Main {
    // 각 숫자마다 불이 켜진 번호
    static boolean[][] num = {{true, true, true, true, true, true, false},
            {false, true, true, false, false, false, false},
            {true, true, false, true, true, false, true},
            {true, true, true, true, false, false, true},
            {false, true, true, false, false, true, true},
            {true, false, true, true, false, true, true},
            {true, false, true, true, true, true, true},
            {true, true, true, false, false, false, false},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 최소 1개~최대 p개를 반전시켜
        // 1 이상 n 이하의 값이 나오도록 함
        // x 층에 멈춰 있고
        // k는 자릿수. 4자리면 501이 0501로 나옴
        // 이때 반전 시킬 LED를 고를 수 있는 경우의 수
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int start = x;
            int to = i;
            for(int j = k - 1; j >= 0; j--){
                int now = (int)Math.pow(10, j);
                int tmpstart = start;
                int tmpto = to;
                start /= now;
                to /= now;
                sum += count(start, to);
                start = tmpstart - (start * now);
                to = tmpto - (to * now);
            }
            if(sum <= p && i != x) {
                // System.out.println(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    static int count(int start, int to){
        // System.out.println(start + " " + to );
        int cnt = 0;
        for(int i = 0; i < 7; i++){
            if(num[start][i] != num[to][i]) cnt++;
        }
        return cnt;
    }
}
