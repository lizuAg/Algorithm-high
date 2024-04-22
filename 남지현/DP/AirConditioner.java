import java.util.*;
class Solution {
    static final int MAX = 100001;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int time = onboard.length;
        int[][] dp = new int[time][51];
        temperature += 10;
        t1 += 10;
        t2 += 10;
        for (int i=0; i<time; i++) {
            Arrays.fill(dp[i], MAX);
        }
        dp[0][temperature] = 0;
        for (int i=0; i<time-1; i++) {
            for (int j=0; j<=50; j++) {
                if (onboard[i] == 1 && (j<t1 || j>t2))
                    continue;
                int next = j;
                if (j<temperature) {
                    next = j+1;
                } else if (j>temperature) {
                    next = j-1;
                }
                dp[i+1][next] = Math.min(dp[i][j], dp[i+1][next]); 
                if (j<50) {
                    dp[i+1][j+1] = Math.min(dp[i][j]+a, dp[i+1][j+1]);
                }
                if (j>0) {
                    dp[i+1][j-1] = Math.min(dp[i][j]+a, dp[i+1][j-1]);
                }
                dp[i+1][j] = Math.min(dp[i][j]+b, dp[i+1][j]);
            }
        }
        int answer = MAX;
        for (int i=0; i<=50; i++) {
            if (onboard[time-1] == 1 && (i<t1 || i>t2)) {
                continue;
            }
            answer = Math.min(dp[time-1][i], answer);
        }
        return answer;
    }
}
