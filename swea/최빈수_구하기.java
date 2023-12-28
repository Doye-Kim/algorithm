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
            int t = sc.nextInt();
            int max = 0;
            HashMap<Integer, Integer> scores = new HashMap<>();
            for(int i = 0; i < 1000; i++){
                int score = sc.nextInt();
                scores.put(score, scores.getOrDefault(score, 0) + 1);
            }
            int num = -1;
            Set<Integer> keySet = scores.keySet();
            for(int k : keySet){
                if(scores.get(k) >= max) {
                    max = scores.get(k);
                    num = num > k ? num : k;
                }
            }
            System.out.println("#" + t + " " + num);
        }
    }
}
