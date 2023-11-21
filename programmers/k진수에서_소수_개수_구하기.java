// https://school.programmers.co.kr/learn/courses/30/lessons/92335?itm_content=course14743
// Solution.java

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        System.out.println(s);
        String[] ss = s.split("0");
        for(String a: ss){
            if(a.isEmpty()) continue;
            if(isPrime(Long.parseLong(a))){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean isPrime(long n) {
        if(n < 2) return false;
        for( int i = 2; i <= (int)Math.sqrt(n); i++)
            if(n % i == 0) return false;
        return true;
    }
}
