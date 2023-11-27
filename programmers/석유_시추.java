//https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;
class Solution {
    public int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] map;
    public int idx = 1;
    public int cnt, n, m;
    public HashMap<Integer, Integer> mapCnt = new HashMap<>();
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cnt = 0;
                if(land[i][j] == 1) mapping(land, i, j);
                if(cnt != 0) mapCnt.put(idx++, cnt);
            }
        }
      
        // 열별로 합 계산하여 최댓값 리턴
        int answer = 0;
        for(int i = 0; i < m; i++){
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(map[j][i] != 0 && !set.contains(map[j][i])){
                    set.add(map[j][i]);
                    sum += mapCnt.get(map[j][i]);
                }
            }
            answer = answer > sum ? answer : sum;
        }
        return answer;
    }
    // land[x][y]가 1일 때 덩어리들의 총 개수를 세고 같은 덩어리끼리 map[][]에서 같은 인덱스를 부여한다. 
    public void mapping(int[][] land, int x, int y){
        cnt++;
        land[x][y] = -1;

        map[x][y] = idx;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || land[nx][ny] <= 0) continue;
            // end = false;
            mapping(land, nx, ny);
        }
        if(cnt != 0) return;
    }
}
