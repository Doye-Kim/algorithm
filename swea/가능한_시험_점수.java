// D4
// 3752. 가능한 시험 점수


import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static HashSet<Integer> set;
    static int[] score;
    static int n;
    static ArrayList<Integer> arr;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            score = new int[n];
            set = new HashSet<>();
            arr = new ArrayList<>();
            for(int i = 0; i < n; i++){
            	score[i] = sc.nextInt();
            }
            set.add(0);
            arr.add(0);
            check(0);
            System.out.println("#" + test_case + " " + set.size());
		}
	}
    static void check(int cnt){
    	if(cnt == n) {
            return;
        }
        int len = arr.size();
        for (int i = 0; i < len; i++) {
			if(!set.contains(arr.get(i)+score[cnt])) {
				set.add(arr.get(i)+score[cnt]);
				arr.add(arr.get(i)+score[cnt]);
			}
		}
		check(cnt+1);
    }
}
