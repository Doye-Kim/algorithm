import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 1;
            int[][] sudoku = new int[9][9];
            Set<Integer> dup = new HashSet<>();
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = sc.nextInt();
                    dup.add(sudoku[i][j]);
                }
                if(dup.size() < 9) answer = 0;
                dup.clear();
            }
            if(answer != 0) answer = calc(dup, sudoku);
            System.out.println("#" + test_case + " " + answer);
        }
    }
  static int calc(Set<Integer> dup, int[][] sudoku){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                  dup.add(sudoku[j][i]);
            }
            if(dup.size() < 9) return 0;
            dup.clear();
        }
        int cnt = 0;
        int y = 0;
        for(int x = 0; x < 9; x += 3){
            for(int i = x; i < x + 3; i++){
                for(int j = y; j < y + 3; j++ ){
                    dup.add(sudoku[j][i]);
                }
            }
            if(dup.size() < 9) return 0;
            dup.clear();
            if(x == 9) y++;
        }
        return 1;
    }
}
