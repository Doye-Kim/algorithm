// https://school.programmers.co.kr/learn/courses/30/lessons/42898
// level 3

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i = 0; i < n + 1; i++){
            map[i][0] = -1;
        }
        for(int i = 0; i < m + 1; i++){
            map[0][i] = -1;
        }
        map[1][1] = 1;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(i == 1 && j == 1) continue;
                if(map[i][j] != -1) {
                    int u = map[i-1][j] == -1 ? 0 : map[i-1][j];
                    int l = map[i][j-1] == -1 ? 0 : map[i][j-1];   
                    map[i][j] = (u + l) == 0 ? 0 : (u + l) > 1000000007 ? (u + l) % 1000000007 : (u + l);
                }
            }
        }
        return map[n][m];
    }
}
