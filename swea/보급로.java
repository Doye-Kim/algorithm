// D4
// 1249. [S/W 문제해결 응용] 4일차 - 보급로

import java.util.*;

class Solution
{
    static boolean[][] isVisited;
    static int N;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
    static int[][] rc;
    static int[][] ans;
    static int min;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            String[] st = new String[N];
            rc = new int[N][N];
            ans = new int[N][N];
            for(int i = 0; i < N; i++){
            	st[i] = sc.next();
            	for(int j = 0; j < N; j++) {
            		rc[i][j] = st[i].charAt(j) - '0';
            	}
            	Arrays.fill(ans[i], Integer.MAX_VALUE);
            }
            min = Integer.MAX_VALUE;
            isVisited = new boolean[N][N];
            ans[0][0] = 0;
            bfs(0, 0);
            System.out.println("#" + test_case + " " + min);
		}	
	}
  public static void bfs(int x, int y){
    	Queue<int[]> q = new LinkedList<>();
    	
    	q.offer(new int[] {x,y});
    	isVisited[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		
    		int[] cur = q.poll();
    		int cX = cur[0];
    		int cY = cur[1];
    		
	        if(cX == N - 1 && cY == N - 1) {
	        	min = min > ans[N - 1][N - 1] ? ans[N - 1][N - 1] : min;
                continue;
	        }
	        if(min <= ans[cX][cY]) continue;
	        
	        for(int i = 0; i < 4; i++){
	            int nX = cX + dir[i][0];
	            int nY = cY + dir[i][1];
	            
	        	if(nX >= 0 && nY >= 0 && nX < N && nY < N && (!isVisited[nX][nY] || ans[nX][nY] > ans[cX][cY] + rc[nX][nY] )){
	                isVisited[nX][nY] = true;
	                ans[nX][nY] = ans[cX][cY] + rc[nX][nY];
	            	q.offer(new int[] {nX, nY});
	            } 
	        }
	    }
    }
}
