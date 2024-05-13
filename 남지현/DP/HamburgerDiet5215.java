import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] S = new int[N];
            int[] C = new int[N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(bf.readLine());
                S[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N+1][L+1];
            for (int i=0; i<=N; i++) {
                for (int cal=0; cal<=L; cal++) {
                    if (i==0 || cal==0) {
                        dp[i][cal] = 0;
                    } else if (C[i-1] <= cal) {
                        dp[i][cal] = Math.max(dp[i-1][cal-C[i-1]]+S[i-1], dp[i-1][cal]);
                    } else {
                        dp[i][cal] = dp[i-1][cal];
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            builder.append("#").append(test_case).append(" ").append(dp[N][L]);
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
