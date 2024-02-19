import java.util.*;
class Solution {
    int[][] dp;
    int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        for (int[] puddle: puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (dp[i][j] != -1) {
                    if (dp[i-1][j] != -1)
                        dp[i][j] += dp[i-1][j];
                    if (dp[i][j-1] != -1)
                        dp[i][j] += dp[i][j-1];
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[n][m]==-1? 0: dp[n][m];
    }
}
