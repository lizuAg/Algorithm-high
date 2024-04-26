//[프로그래머스] 사칙연산 (https://school.programmers.co.kr/learn/courses/30/lessons/1843)

import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int N = arr.length/2 + 1;
        int[][] max_dp = new int[N][N];
        int[][] min_dp = new int[N][N];
        
        for(int i=0; i<N; i++) {
            Arrays.fill(max_dp[i], Integer.MIN_VALUE);
            Arrays.fill(min_dp[i], Integer.MAX_VALUE);
        }

        
        for(int i=0; i<N; i++) {
            max_dp[i][i] = Integer.parseInt(arr[i*2]);
            min_dp[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        for(int cnt=1; cnt<N; cnt++) {
            for(int i=0; i<N-cnt; i++) {
                int j = i+cnt;
                for(int k=i; k<j; k++) {
                    String operator = arr[k*2+1];
                    
                    if(operator.equals("+")) {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                    }
                    else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                    }
                }
            }
        }
            return max_dp[0][N-1];
    }
}
