import java.util.*;
import java.io.*;

// 기타리스트

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] V = new int[N+1];
        st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;
        for (int i=1; i<=N; i++) {
            for (int j=0; j<=M; j++) {
                if (dp[i-1][j]) {
                    if (j-V[i]>=0) {
                        dp[i][j-V[i]] = true;
                    }
                    if (j+V[i]<=M) {
                        dp[i][j+V[i]] = true;
                    }
                }
            }
        }
        int answer = -1;
        for (int i=M; i>=0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
