import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[0] * n;
        long mid = 0;
        while (left < right) {
            mid=(left+right)/2;
            long sum=0;
            for (int time: times) {
                sum += mid/time;
            }
            if (sum < n) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
