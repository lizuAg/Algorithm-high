//BOJ 15486번 퇴사2 (https://www.acmicpc.net/submit/15486/77604495)

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            String[] line = br.readLine().split(" ");
            
            int t = Integer.parseInt(line[0]);
            int p = Integer.parseInt(line[1]);

            dp[i] = Math.max(dp[i-1], dp[i]);
            
            if(i+t-1<=N) {
                dp[i+t-1] = Math.max(dp[i-1] + p, dp[i+t-1]);
            }
        }

        br.close();

        int answer = findSum(N);
        
        System.out.println(answer);
    }

    static int findSum(int N) {
        for(int i=N; i>=0; i--) {
            if(dp[i] != 0) {
                return dp[i];
            }
        }
        return 0;
    }
}
