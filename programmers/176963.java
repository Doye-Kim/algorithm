// https://school.programmers.co.kr/learn/courses/30/lessons/176963
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> names = new HashMap<>();
       
       //초기화
        for(int i = 0; i < name.length; i++){
            names.put(name[i], yearning[i]);
        }
        
        //일치하는 값 찾아서 결과에 넣기
        for(int i = 0; i < photo.length; i++){
            for(int j = 0; j < photo[i].length; j++){
                if(names.get(photo[i][j]) != null){
                    int a = names.get(photo[i][j]);
                    answer[i] += a;
                }
            }
        }
        return answer;
    }
}
