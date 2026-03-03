import java.io.*;
import java.util.*;

public class Main {

    static int[][] map = new int[20][20];
    static int[] dy = {0, 1, 1, -1};
    static int[] dx = {1, 0, 1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {

                if (map[i][j] == 0) continue;

                int color = map[i][j];

                for (int d = 0; d < 4; d++) {

                    int py = i - dy[d];
                    int px = j - dx[d];

                    if (py >= 1 && px >= 1 && py <= 19 && px <= 19 && map[py][px] == color) continue;

                    int cnt = 1;
                    int ny = i;
                    int nx = j;

                    while (true) {
                        ny += dy[d];
                        nx += dx[d];

                        if (ny < 1 || nx < 1 || ny > 19 || nx > 19)
                            break;

                        if (map[ny][nx] != color)
                            break;

                        cnt++;
                    }

                    if (cnt == 5) {
                        System.out.println(color);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}