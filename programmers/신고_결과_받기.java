// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// Solution.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //입력값 순서대로 접근하기 위한 Map
        Map<String, Integer> idIndex = new HashMap<>();
        
        //신고 당한 ID, 이를 신고한 ID List
        Map<String, List<String>> reportMap = new HashMap<>();
        

        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
            reportMap.put(id_list[i], new ArrayList<>());
        }

		//신고 당한 사람의 신고자 ID List에 현 신고자 ID가 없으면 추가
        //있으면 안 함 == 중복 x
        for (String reported : report) {
            String[] temp = reported.split(" ");
            if (!reportMap.get(temp[1]).contains(temp[0])) {
                reportMap.get(temp[1]).add(temp[0]);
            }
        }
        
        // size로 정지 여부 확인 후 idIndex에 저장해둔 index로 answer 수정
        for (String id : reportMap.keySet()) {
            if (k <= reportMap.get(id).size()) {
                for (String reporter : reportMap.get(id)) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
