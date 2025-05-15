import java.util.*;
import java.io.*;

public class Main
{
    static int r, c, n;
    static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		r = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		n = Integer.parseInt(arr[2]);
		
		map = new char[r][c];
		for(int i = 0; i < r; i++){
		    String str = br.readLine();
		    for(int j = 0; j < c; j++){
		        map[i][j] = str.charAt(j);
		    }
		}
		StringBuilder sb = new StringBuilder();
		if (n == 1) {
            printMap(map);
        } else if (n % 2 == 0) {
            printFullO();
        } else {
            char[][] afterFirstBomb = bomb(map);
            if (n % 4 == 3) {
                printMap(afterFirstBomb);
            } else {
                printMap(bomb(afterFirstBomb));
            }
        }
		System.out.print(sb);
	}
	static char[][] bomb(char[][] before){
        char[][] filled = new char[r][c];
        for (char[] row : filled) Arrays.fill(row, 'O');

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (before[i][j] == 'O') {
                    filled[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dy[d];
                        int nj = j + dx[d];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                            filled[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return filled;
	}
	static void printMap(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            sb.append(row).append('\n');
        }
        System.out.print(sb);
    }

    static void printFullO() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append("O".repeat(c)).append('\n');
        }
        System.out.print(sb);
    }
}
