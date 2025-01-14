import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] stars;
    static int total, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        total = n * 2 - 1;
        stars = new boolean[n][total];

        drawStar(0, total / 2, n);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < total; j++) {
                sb.append(stars[i][j] ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void drawStar(int row, int col, int size) {
        if (size == 3) {
            stars[row][col] = true;
            stars[row + 1][col - 1] = true;
            stars[row + 1][col + 1] = true;
            for (int i = -2; i <= 2; i++) {
                stars[row + 2][col + i] = true;
            }
            return;
        }

        int newSize = size / 2;
        drawStar(row, col, newSize);
        drawStar(row + newSize, col - newSize, newSize);
        drawStar(row + newSize, col + newSize, newSize);
    }
}
