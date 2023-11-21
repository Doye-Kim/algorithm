// https://school.programmers.co.kr/learn/courses/30/lessons/43238
// Solution.java

class Solution {
    public long solution(int n, int[] times) {
        int maxTime = times[0];
        for (int i = 1; i < times.length; i++)
        {
            maxTime = (maxTime > times[i]) ? maxTime : times[i];
        }

        long min = 0;
        long max = (long)maxTime * (long)n;

        while (min < max)
        {
            long mid = (max - min)/ 2 + min;
            long cnt = count(mid, times);
            
          //주어진 인원수 처리 가능 여부에 따라 max 값 혹은 min 값이 달라짐
            if (cnt >= n)
            {
                max = mid;
            }
            else
            {
                min = mid + 1;
            }
        }

        return min;
    }

// 주어진 시간(mid)동안 처리할 수 있는 사람 수 구하기
    long count(long mid, int[] times)
    {
        long cnt = 0;
        for (int i = 0; i < times.length; i++)
        {
            cnt += mid / times[i];
        }
        return cnt;
    }
}
