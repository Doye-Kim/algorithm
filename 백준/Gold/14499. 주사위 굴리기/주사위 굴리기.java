import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static int[] dice = new int[6];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < k; i++){
            int d = Integer.parseInt(st.nextToken()) - 1;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            y = ny;
            x = nx;
            
            roll(d);
            if(map[y][x] == 0) map[y][x] = dice[1];
            else {
                dice[1] = map[y][x];
                map[y][x] = 0;
            }
            sb.append(dice[3]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    static void roll(int d){
        int tmp = dice[1];
        switch(d){
            case 0:
                dice[1] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[5];
                dice[5] = tmp;
                break;
            case 1:
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[4];
                dice[4] = tmp;
                break;
            case 2:
                dice[1] = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[2];
                dice[2] = tmp;
                break;
            case 3:
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[0];
                dice[0] = tmp;
                break;
        }
    }
}
