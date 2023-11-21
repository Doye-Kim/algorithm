// https://school.programmers.co.kr/learn/courses/30/lessons/84512
// Solution.java

class Solution {
    int cnt = 0;
    public int solution(String word) {
        int answer = 0;
        char[] alp = {'A', 'E', 'I', 'O', 'U'};
        // 중복 순열 n^r
        int A = permutation(5,1) + permutation(5,2) + permutation(5,3) + permutation(5,4) + 1;
        int AA = permutation(5,1) + permutation(5,2) + permutation(5,3) + 1;
        int AAA = permutation(5,1) + permutation(5,2) + 1;
        int AAAA = permutation(5,1) + 1;
        int[] a = {A, AA, AAA, AAAA, 1};
        
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < alp.length; j++){
                if(word.charAt(i) == alp[j]){
                    break;
                }
                cnt += a[i];
            }
            cnt += 1;
        }
        return cnt;
    }
    public int permutation(int n, int r){
        int result = 1;
        for(int i = 0; i < r; i++){
            result *= n;
        }
        return result;
    }
}
