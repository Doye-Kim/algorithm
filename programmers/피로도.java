// https://school.programmers.co.kr/learn/courses/30/lessons/87946
// Solution.java

class Solution {
    boolean[] isVisited;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return max;
    }
    public void dfs(int cnt, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(isVisited[i] == false && k >= dungeons[i][0]){
                isVisited[i] = true;
                dfs(cnt + 1, k - dungeons[i][1], dungeons);
                isVisited[i] = false;
            }
            max = max > cnt ? max : cnt;
        }
    }
}
