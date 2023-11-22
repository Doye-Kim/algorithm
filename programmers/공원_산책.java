// https://school.programmers.co.kr/learn/courses/30/lessons/172928

import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        //routes 분할하기
        String[][] splitRoutes = new String[routes.length][2];
        for(int i = 0; i < routes.length; i++){
            splitRoutes[i] = routes[i].split(" ");
        }
        return move(splitRoutes, park);
    }
    
    //시작점 찾기
    static int[] findStart(String[] park){
        int[] result = {0, 0};
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    
    //이동
    int[] move(String[][] splitRoutes, String[] park){
        int rn = splitRoutes.length;
        int[] start = findStart(park);

        for (int i = 0; i < rn; i++) {
            int success = 1;
            
            //이동해야 하는 칸 수
            int k = Integer.parseInt(splitRoutes[i][1]);
            
            if(splitRoutes[i][0].equals("E")){
                for(int j = start[1]; j <= start[1] + k; j++){
                    
                    //공원 벗어남
                    if(start[1] + k >= park[0].length()) {
                        success = 0;
                        break;
                    }
                    
                    // 장애물 만남
                    else if(park[start[0]].charAt(j) == 'X'){
                        success = 0;
                        break;
                    }
                }
                //이동 가능하면 시작점을 옮겨줌
                if(success == 1){
                    start[1] += k;
                }
            }
            
            // W일 때, 위와 거의 동일하나 +하던 것들은 -로 바뀜
            if(splitRoutes[i][0].equals("W")){
                for(int j = start[1]; j >= start[1] - k; j--){
                    if(start[1] - k < 0) {
                        success = 0;
                        break;
                    }
                    else if(park[start[0]].charAt(j) == 'X'){
                        success = 0;
                        break;
                    }
                }
                if(success == 1){
                    start[1] -= k;
                }
            }
            
            // S일 때, 위의 E, W는 가로로 움직였다면 S, N은 y축이 움직여야 해서
            // start[0]의 값이 조절됨
            if(splitRoutes[i][0].equals("S")){
                for(int j = start[0]; j <= start[0] + k; j++){
                    if(start[0] + k >= park.length) {
                        success = 0;
                        break;
                    }
                    else if(park[j].charAt(start[1]) == 'X'){
                        success = 0;
                        break;
                    }  
                }
                if(success == 1){
                    start[0] += k;
                }
            }
            if(splitRoutes[i][0].equals("N")){
                for(int j = start[0]; j >= start[0] - k; j--){
                    if(start[0] - k < 0) {
                        success = 0;
                        break;
                    }
                    else if(park[j].charAt(start[1]) == 'X'){
                        success = 0;
                        break;
                    }  
                }
                if(success == 1){
                    start[0] -= k;
                }
            }
		}
        return start;
    }
}
