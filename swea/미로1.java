// D4
// 1226. [S/W 문제해결 기본] 7일차 - 미로1

import java.util.Scanner;
// 아래는 ide에서 테스트 하려고 import 한 거라 필요 업슴
import java.util.Arrays;
import java.io.FileInputStream;

class Solution
{
    static int WH = 16; //가로세로 값
    static int answer, x, y; //답, 현재 좌표 x, y
    static int[] dx = {-1, 1, 0, 0}; // 방향 설정을 위한 배열  dx, dy
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited; //방문한 길 확인
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10; // testcase 개수
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int Tnum = sc.nextInt();
			visited = new boolean[WH][WH];
            int[][] rc = new int[WH][WH];

			// 미로 생성
            // 출발지 좌표 x, y 저장
            for(int i = 0; i < WH; i++){
                String[] tmp =  sc.next().split("");
                for(int j = 0; j < WH; j++){
                     rc[i][j] = Integer.parseInt(tmp[j]);
                    if(rc[i][j] == 2 ) { 
                         x = i; 
                         y = j;
                    }
                }
            }
            answer = 0;
            dfs(x, y, rc);
            System.out.println("#" + Tnum + " " + answer);
		}     
	}
    static void dfs(int x, int y, int[][] rc){
    	visited[x][y] = true;
        if(answer == 1) return;
        //도착
        if(rc[x][y] == 3) { 
            answer = 1; 
            return; 
        }
        // 상하좌우 갈 수 있는 길 찾기
		for(int i = 0; i < 4; i++){
        	int newX = x + dx[i];
            int newY = y + dy[i];
            // 새 좌표가 미로 바깥에 있으면 continue
            if(newX < 0 || newX > WH || newY < 0 || newY > WH) continue;
            // 방문한 적 없고, 값이 0이거나 3일 때 재귀
            if(!visited[newX][newY] && (rc[newX][newY] == 0 || rc[newX][newY] == 3)) {
                dfs(newX, newY, rc);
            }
        }
    }
}
