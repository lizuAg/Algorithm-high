import java.util.*;

// 금과 은 운반하기

class Solution {
    
    static final long MAX = 400_000_000_000_000L;
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1, left = 1, right = MAX;
        int N = w.length;
        while (left <= right) {
            long mid = (left+right)/2;
            int gold = 0, silver = 0, sum = 0;
            for (int i=0; i<N; i++) {
                long cnt = mid/(2*t[i]);
                if (mid%(2*t[i]) >= t[i]) {
                    cnt++;
                }
                gold += Math.min(g[i], w[i]*cnt);
                silver += Math.min(s[i], w[i]*cnt);
                sum += Math.min(g[i]+s[i], w[i]*cnt);
            }
            if (gold>=a && silver>=b && sum>=a+b) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}
