// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// Solution.java

import java.util.*;
class Solution {
    boolean[] isVisited;
    int min = 100;
    //left = 왼쪽 전력망 송전탑 번호들
    Set<Integer> left = new HashSet<Integer>();
    
    public int solution(int n, int[][] wires) {
        isVisited = new boolean[n - 1];
        for(int x = 0; x < wires.length; x++){
            left.clear();
            left.add(wires[x][0]);
            dfs(x, 1, wires, x);

            int sizeL = left.size();
            int sizeR = Math.abs(n - sizeL);
            int sub = Math.abs(sizeL - sizeR);
            min = min > sub ? sub : min;
        }
        return min;
    }
    public void dfs(int x, int lc, int[][] wires, int origin){
        for(int i = 0; i < wires.length; i++){
            if(i == origin || i == x) continue;
            
            int a = wires[i][0];
            int b = wires[i][1];
            int focusA = wires[x][0];
            int focusB = wires[x][1];
            
            // 방문하지 않은 송전탑일 때
            if(isVisited[i] == false){
            	// 이미 방문했는데 false가 되어 중복일 경우 continue
                if(left.contains(a) && left.contains(b)) continue;
                
                // origin == x일 땐 왼쪽 송전탑의 부모, 자식만 고려하면 되지만
                // origin != x일 땐 이미 x가 왼쪽에 있는 송전탑의 부모, 자식이므로
                // 오른쪽, 왼쪽 모두 고려해야 함
                if(origin != x){
                    if(a == focusA || b == focusA || a == focusB || b == focusB){
                    isVisited[i] = true;
                    left.add(a);
                    left.add(b);
                    dfs(i, ++lc, wires, origin);
                    isVisited[i] = false;
                }      
            }
                else{
                    if(a == focusA || b == focusA){
                        isVisited[i] = true;
                        left.add(a);
                        left.add(b);
                        dfs(i, ++lc, wires, origin);
                        isVisited[i] = false;
                    }
                }
            }
        }
    }
}
