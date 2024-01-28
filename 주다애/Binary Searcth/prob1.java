import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 이분탐색을 위한 정렬
        Arrays.sort(times);
        long min = times[0];
        // n은 int이므로 long으로 형변환 해주어야 한다.
        long max = times[times.length - 1] * (long) n;
        while(min <= max) {
            // 중간값
            long mid = (min + max) / 2;
            // 통과한 사람 수의 합
            long sum = 0;
            
            for(int time : times) {
                sum += (mid / time);
            }
            
            if(sum >= n) {
                answer = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return answer;
    }
}
