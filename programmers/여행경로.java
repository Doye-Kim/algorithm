// https://school.programmers.co.kr/learn/courses/30/lessons/43164
// Solution.java

import java.util.ArrayList;
import java.util.Collections;
class Solution {
    ArrayList<String> routeList = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        boolean[] isUse = new boolean[tickets.length];
        dfs(isUse, "ICN", "ICN", tickets, 0);

        Collections.sort(routeList);
        String[] answer = routeList.get(0).split(" "); 
        return answer;
    }
    
    public void dfs(boolean[] isUse, String start, String route, String[][] tickets, int cnt){
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals(start) && !isUse[i]){
                String next = tickets[i][1];
                isUse[i] = true;
                dfs(isUse, next, route + " " + next, tickets, cnt+1);
                isUse[i] = false;
            }
            if(cnt == tickets.length){
                routeList.add(route);
                return;
            }
        }
    }
}
