// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// Solution.java

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux, luy, rdx, rdy;
        lux = luy = 50;
        rdx = rdy = 0;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < lux) lux = i;
                    if(j < luy) luy = j;
                    if(i > rdx) rdx = i;
                    if(j > rdy) rdy = j;
                }
            }
        }
        int[] answer = {lux, luy, rdx + 1, rdy + 1};
        return answer;
    }
}
