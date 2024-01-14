// 처음 코드 런타임 에러 나서 갈아 엎기 전에 어떻게든 해보려고 고쳤더니 이렇게 됐다...


import java.util.*;
import java.io.*;

class Solution
{
  static int[][] peoples;
  static boolean[] visited;
  static int n, sum;

	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
      //input
		  String[] a = bf.readLine().split(" ");
      n = Integer.parseInt(a[0]);
      int m = Integer.parseInt(a[1]);
      peoples = new int[n + 1][n + 1];
      visited = new boolean[n + 1];
      for(int i = 0; i < m; i++){
        String[] b = bf.readLine().split(" ");
        int x = Integer.parseInt(b[0]);
        int y = Integer.parseInt(b[1]);
        peoples[x][y] = 1;
        peoples[y][x] = 1;
      }
      sum = 0;
      // 계산
      // calc에서 한 무리를 dfs로 찾기 때문에 여기의 반복문에서 아직 방문한 적 없고, 
      //peoples[i][j]의 값이 1인 걸 찾았다면 이전과 다른 무리이기 때문에 sum++ 
      for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
          if((!visited[i] || !visited[j]) && peoples[i][j] == 1) {
            sum++;
            visited[i] = true;
            calc(i, j);
          }
       }
      }
      // 한 명만 있어도 한 무리로 처리되기 때문에 정보가 제공되지 않아 방문한 적 없는 사람의 수를 더한다
      for(int i = 1; i <= n; i++) {
        if(!visited[i]) sum++;
      }
			System.out.println("#" + test_case + " " + sum);
		}
	}
  
  static void calc(int x, int y){
    for(int j = 1; j <= n; j++){
      if(!visited[j] && peoples[x][j] == 1) {
        visited[j] = true;
        calc(x, j);
      }
      if(!visited[j] && peoples[y][j] == 1) {
        visited[j] = true;
        calc(y, j);
      }
    }
  }
}
