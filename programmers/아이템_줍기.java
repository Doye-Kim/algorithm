// https://school.programmers.co.kr/learn/courses/30/lessons/87694
// Solution.java

import java.util.*;
class Solution {
    int[][] wh = {{0, 1, 0, -1}, {1, 0, -1, 0}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 모든 값을 두 배로
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        for(int i = 0; i < rectangle.length; i++) {
            var rec = rectangle[i];
            rectangle[i] = new int[] { rec[0] * 2, rec[1] * 2, rec[2] * 2, rec[3] * 2};
        }
        boolean[][] map = new boolean[102][102], vst = new boolean[102][102];
        for(int[] rec : rectangle) {
            for(int i = rec[0]; i <= rec[2]; i++) {
                for(int j = rec[1]; j <= rec[3]; j++) {
                    map[i][j] = true;
                }
            }
        }
        // 테두리만 남겨둔다.
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                int inner = 0;
                for(int[] rec : rectangle) {
                    if(rec[0] < i && i < rec[2] && rec[1] < j && j < rec[3]) inner++;
                }
              if(inner != 0) q.add(new int[] { i, j });
            }
        }
        for(int[] p : q) map[p[0]][p[1]] = false;
        // 이후는 일반 bfs
        q = new LinkedList<>();
        q.add(new int[] { characterX, characterY, 0 });
        vst[characterX][characterY] = true;
        while(!q.isEmpty()) {
            int[] p = q.poll();
            if(p[0] == itemX && p[1] == itemY) answer = p[2] / 2;
            else {
                for(int i = 0; i < 4; i++) {
                    int x = p[0] + wh[0][i];
                    int y = p[1] + wh[1][i];
                    if(0 <= x && 0 <= y && x < 102 && y < 102 && !vst[x][y] && map[x][y]) {
                        q.add(new int[] {x, y, p[2] + 1});
                        vst[x][y] = true;
                    }
                }
            }
        }
        return answer;
    }
}
