import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N];
        int[] V = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][K+1];
        for (int i=0; i<=N; i++) {
            for (int maxWeight=0; maxWeight<=K; maxWeight++) {
                if (i==0 || maxWeight==0) {
                    dp[i][maxWeight] = 0;
                } else if (maxWeight >= W[i-1]) {
                    dp[i][maxWeight] = Math.max(dp[i-1][maxWeight-W[i-1]]+V[i-1], dp[i-1][maxWeight]);
                } else {
                    dp[i][maxWeight] = dp[i-1][maxWeight];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
