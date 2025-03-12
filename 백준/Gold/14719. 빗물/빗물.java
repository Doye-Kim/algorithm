import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        // 방법 1   
        // w*h 2차원 배열을 만들어 가로 한 줄씩 순회하며
        // 사이에 낀 개수를 찾음
        // 시간 초과는 안 날 듯
        // 왼쪽부터 블록이 있으면 그 이후 빈칸을 카운트 한다. 
        // 막히면 그때까지의 빈 칸의 개수를 정답에 합함

        boolean[][] blocks = new boolean[h][w];
        for(int i = 0; i < w; i++){
            int nh = Integer.parseInt(st.nextToken());
            for(int j = h - 1; j >= h - nh; j--){
                blocks[j][i] = true;
            }
        }
        int ans = 0;
        for(int i = 0; i < h; i++){
            boolean flag = false;
            int cnt = 0;
            for(int j = 0; j < w; j++){
                if(!flag && blocks[i][j]) flag = true;
                else if(flag && !blocks[i][j]) cnt++;
                else if(flag && blocks[i][j]) {
                    ans += cnt;
                    cnt = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
