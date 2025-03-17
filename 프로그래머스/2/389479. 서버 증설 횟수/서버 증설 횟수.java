import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        HashMap<Integer, Integer> map = new HashMap<>();
        //i시각의 증설횟수 cnt => (i, cnt)
        int nowCnt = 0;
        for(int i = 0; i < 24; i++){
            server[i] = players[i] / m;
            if(map.containsKey(i - k)) {
                nowCnt -= map.get(i - k);
                map.remove(i - k);
            }
            int diff = server[i] - nowCnt;
            if(diff > 0) {
                map.put(i, diff);
                nowCnt += diff;
                answer += diff;
            }
        }
        System.out.println(Arrays.toString(server));
        return answer;
    }
}