import java.util.*;
import java.io.*;
 
class Solution
{
    static int n, min;
    static boolean[] isVisited;
    static int[] company, home;
    static int[][] clients;
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(bf.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(bf.readLine());
            min = Integer.MAX_VALUE;
 
            String a = bf.readLine();
            clients = new int[n][2];
            company = new int[2];
            home = new int[2];
            String[] aa = a.split(" ");
            company[0] = Integer.parseInt(aa[0]);
            company[1]  = Integer.parseInt(aa[1]);
            home[0] = Integer.parseInt(aa[2]);
            home[1] = Integer.parseInt(aa[3]);
             
            for(int i = 4, j = 0; i < 4 + n * 2; i+=2, j++){
                clients[j][0] = Integer.parseInt(aa[i]);
                clients[j][1] = Integer.parseInt(aa[i + 1]);
            }
            //dfs
            isVisited = new boolean[n];
            dfs(company, 0, 0);
            System.out.println("#" + test_case+ " " + min);
        }
        bf.close();
    }
    static void dfs(int[] prev, int count, int sum){
        if(count == n){
            sum += calc(prev, home);
            min = Math.min(min, sum);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!isVisited[i] && sum < min){
                isVisited[i] = true;
                dfs(clients[i], count + 1, sum + calc(prev, clients[i]));
                isVisited[i] = false;
            }
        }
    }
    static int calc(int[] start, int[] end){
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}
