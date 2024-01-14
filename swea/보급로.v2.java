import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
 
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] a = br.readLine().split("");
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(a[j]);
                }
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {0, 0});
            int[][] ans = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int min = Integer.MAX_VALUE;
            ans[0][0] = map[0][0];
            visited[0][0] = true;
 
             
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];    
                if(ans[cx][cy] >= min) continue;
                if(cx == n - 1 && cy == n - 1) {
                    min = min > ans[n-1][n-1] ? ans[n-1][n-1] : min;
                    continue;
                }
                for(int i = 0; i < 4; i++){
                    int nx = cx + dirX[i];
                    int ny = cy + dirY[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && (!visited[nx][ny] || ans[nx][ny] > ans[cx][cy] + map[nx][ny])) {   
                        visited[nx][ny] = true;
                        ans[nx][ny] = ans[cx][cy] + map[nx][ny];
                        q.offer(new int[] {nx, ny});
                        //System.out.println(cx + "  "+ cy + "  "+ nx + " "  + ny + "       "  + ans[nx][ny] );
                    }
                     
                }
            }
            System.out.println("#" + test_case + " " + min);
        }
    }
}
