//BOJ 11727번 2xn 타일링 2(https://www.acmicpc.net/submit/11727/77916461)

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println(1);
            return;
        }
        
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        }

        System.out.println(dp[n]);
    }
}
