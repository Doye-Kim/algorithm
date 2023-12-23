//https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> out = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            // 시간, 차량번호, IN/OUT
            String[] a = records[i].split(" ");
            // 시간 계산
            String[] time = a[0].split(":");
            int t = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            // 입차면 map에 차량 번호와 입차 시간 넣음
            // 출차면 out에 차량 번호, 누적 시간 넣고 map에서 해당 차량 삭제
            if(a[2].equals("IN")) map.put(a[1], t);
            if(a[2].equals("OUT")) {
                out.put(a[1], out.getOrDefault(a[1], 0) + t - map.get(a[1]));
                map.remove(a[1]);
            }
        }
        int end = 23 * 60 + 59;
        // 출차 내역 없는 차 누적 시간 계산
        map.forEach((key, value)->{
	        out.put(key, out.getOrDefault(key, 0) + end - value);
        });

        // 요금 계산
        out.forEach((key, value) -> {
            int minutes = (value - fees[0]);
            if(minutes < 0) out.put(key, fees[1]);
            else if(minutes % fees[2] == 0) out.put(key, (minutes / fees[2]) * fees[3] + fees[1]);
            else out.put(key, (minutes / fees[2] + 1) * fees[3] + fees[1]);
        });
      
        // 정렬 후 리턴
        List<String> keySet = new ArrayList<>(out.keySet());
        List<Integer> list = new ArrayList<>();
        Collections.sort(keySet);

        for (String key : keySet) {
            list.add(out.get(key));
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
