import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[][] dp;
    static int[][] items;
    
    public static void main(String[] args) throws Exception {
        input();
        
        for(int i=1; i<=K; i++) {//무게제한
            for(int j=1; j<=N; j++) {//j번째 보석
                int weight = items[j][0];
                int value = items[j][1];

                if(weight > i) //못넣음, 부분 최적해가 최적해
                    dp[j][i] = dp[j-1][i];
                else //넣을 수 있음. 넣는다 vs. 안 넣는다.
                    dp[j][i] = Math.max(dp[j-1][i-weight] + value, dp[j-1][i]);
            }
        }

        System.out.println(dp[N][K]);
    }
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        dp = new int[N+1][K+1];
        items = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            line = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(line[0]);
            items[i][1] = Integer.parseInt(line[1]);
        }
        
        br.close();
    }
}
