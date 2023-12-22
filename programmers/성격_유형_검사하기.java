//https://school.programmers.co.kr/learn/courses/30/lessons/118666

import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] list = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(int i = 0; i < list.length; i++){
            cnt.put(list[i], 0);
        }
        for(int i = 0; i < choices.length; i++){
            if(choices[i] < 4){
                char now = survey[i].charAt(0);
                cnt.put(now, cnt.get(now) + 4 - choices[i]);
            }
            if(choices[i] > 4){
                char now = survey[i].charAt(1);
                cnt.put(now, cnt.get(now) + (choices[i] % 4));
            }
        }

        ArrayList<Character> anslist = new ArrayList<>();
        if(cnt.get('R') >= cnt.get('T'))  anslist.add('R');
        else anslist.add('T');
        
        if(cnt.get('C') >= cnt.get('F')) anslist.add('C');
        else anslist.add('F');
        
        if(cnt.get('J') >= cnt.get('M')) anslist.add('J');
        else anslist.add('M');
        
        if(cnt.get('A') >= cnt.get('N')) anslist.add('A');
        else anslist.add('N');
        

        StringBuilder answer = new StringBuilder();
        for(char a : anslist){
            answer.append(a);
        }
        return answer.toString();
    }
}
