class Solution {
    public int solution(int n, int[] money) {
        int len = money.length;
        int[][] dp = new int[len + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (j - money[i - 1] >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[len][n];
    }
}
