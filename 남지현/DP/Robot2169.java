import java.util.*;
import java.io.*;

// 백준2169 - 로봇 조종하기

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = board[0][0];
        for (int j=1; j<M; j++) {
            dp[0][j] = dp[0][j-1]+board[0][j];
        }
        
        for (int i=1; i<N; i++) {
            int[] tmp1 = new int[M];
            int[] tmp2 = new int[M];

            tmp1[0] = dp[i-1][0] + board[i][0];
            for (int j=1; j<M; j++) {
                tmp1[j] = Math.max(dp[i-1][j], tmp1[j-1]) + board[i][j];
            }

            tmp2[M-1] = dp[i-1][M-1] + board[i][M-1];
            for (int j=M-2; j>=0; j--) {
                tmp2[j] = Math.max(dp[i-1][j], tmp2[j+1]) + board[i][j];
            }

            for (int j=0; j<M; j++) {
                dp[i][j] = Math.max(tmp1[j], tmp2[j]);
            }
        }
        
        System.out.println(dp[N-1][M-1]);
    }
}
