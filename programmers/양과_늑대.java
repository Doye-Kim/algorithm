// https://school.programmers.co.kr/learn/courses/30/lessons/92343
// Solution.java

import java.util.ArrayList;
import java.util.List;

class Solution {
    static ArrayList<Integer>[] nodes;
	static int[] Info;
	static int maxSC = 0;
    
    public int solution(int[] info, int[][] edges) {
        Info = info;
		nodes = new ArrayList[info.length];
        
        //nodes[0]엔 0번 노드의 자식 노드 번호가 들어감
		for (int[] l : edges) {
			int parent = l[0];
			int child = l[1];
			if (nodes[parent] == null) {
				nodes[parent] = new ArrayList<>();
			}
			nodes[parent].add(child);
		}
        
        //방문해야 할 노드들을 list에 저장함
        //첫 번째로 방문할 노드가 0번 노드(=루트노드)이기 때문에 add(0)
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list);

        return maxSC;
    }
    public void dfs(int idx, int sc, int wc, List<Integer> nextPos){
        System.out.println("dfs!" + idx + " " + nextPos);
        if(Info[idx] == 0) sc++;
        else wc++;
        
        //늑대의 수가 양과 같거나 많으면 return;
        if (wc >= sc) {
            return;
        }
		maxSC = sc > maxSC ? sc : maxSC;
        
        // 다음에 방문해야 할 노드 저장 list
        List<Integer> list = new ArrayList<>();
        
        // 아직 방문하지 않은 노드 누적
		list.addAll(nextPos);
        
        // 방문한 노드 삭제
		list.remove(Integer.valueOf(idx));
        
        // 현재 방문한 노드 자식들 있으면 list에 추가
		if (nodes[idx] != null) {
			for (int child : nodes[idx]) {
				list.add(child);
			}
		}
        
		for (int next : list) {
			dfs(next, sc, wc, list);
		}
    }
}
