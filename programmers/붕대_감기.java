//https://school.programmers.co.kr/learn/courses/30/lessons/250137

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int hp = health;
        int cnt = 0;
        int answer = 0;
        int j = 0;
        for(int i = 1; i <= attacks[attacks.length - 1][0]; i++){
            if(i == attacks[j][0]) {
                cnt = 0;
                hp -= attacks[j][1];
                j++;
            }
            else {
                cnt++;
                hp += x;
                if(cnt == t) {
                    hp += y;
                    cnt = 0;
                }
            }
            if(hp > health) hp = health;
            if(hp <= 0) {
                hp = -1; 
                break;
            }
        }

        return hp;
    }
}
