// https://school.programmers.co.kr/learn/courses/30/lessons/43162#
// Solution.java

class Solution {
    int answer = 0;
    int N; // computers.length
    boolean[] visited; //방문한 컴퓨터인지 확인
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];
        //3번
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int idx, int[][] computers){
    	// 0번![](https://velog.velcdn.com/images/kmdy/post/62c608c1-5547-43ea-989d-d650d3ffd3bf/image.jpg)

        visited[idx] = true;
        // 1, 2번
        for(int j = 0; j < N; j++){
            if(idx != j && visited[j] == false && computers[idx][j] == 1){
                dfs(j, computers);
            }
        }
    }
}
