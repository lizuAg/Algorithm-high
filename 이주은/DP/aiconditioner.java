//[프로그래머스] 에어컨 (https://school.programmers.co.kr/learn/courses/30/lessons/214289)

import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        //최하 온도(영하 10도) 보정.
        temperature += 10;
        t1 += 10; t2 += 10;
        
        int cnt = onboard.length;
        int T1 = Math.min(t1, temperature);
        int T2 = Math.max(t2, temperature);
        
        ///dp[i][j] : i분에 j도를 유지하기 위한 최소 전력 소비
        int[][] dp = new int[cnt][51];
        for(int i=0; i<cnt; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][temperature] = 0;
        
        
        for(int i=1; i<cnt; i++) {
            int start = T1;
            int end = T2;

            if(onboard[i] == 1) {
                start = t1; end = t2;
            }
            
            for(int j=start; j<=end; j++) {
                int temp = Integer.MAX_VALUE;
                
                //dp[i-1][j]
                if(dp[i-1][j] == Integer.MAX_VALUE);
                else if(temperature == j)
                    temp = dp[i-1][j];
                else
                    temp = dp[i-1][j] + b;
                
                //dp[i-1][j-1] -> +1필요. (현재 온도가 실외온도보다 낮으면 에어컨 꺼서 높임./실외온도가 현재 온도보다 높으면 에어컨 꺼서 높임)
                if (j<1 || dp[i-1][j-1] == Integer.MAX_VALUE);
                else if(j-1 < temperature)
                    temp = Math.min(temp, dp[i-1][j-1]);
                else
                    temp = Math.min(temp, dp[i-1][j-1] + a);
                
                //dp[i-1][j+1] -> -1 필요.(현재 온도가 실외온도보다 높으면 에어컨 꺼서 낮춤.)
                if(j>49 || dp[i-1][j+1]== Integer.MAX_VALUE);
                else if(j+1 > temperature)
                    temp = Math.min(temp, dp[i-1][j+1]);
                else
                    temp = Math.min(temp, dp[i-1][j+1]+a);

                dp[i][j] = temp;
            }
        }

        Arrays.sort(dp[cnt-1]);
        return dp[cnt-1][0];
    }
    
}
