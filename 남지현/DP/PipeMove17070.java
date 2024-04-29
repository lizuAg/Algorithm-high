import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] home = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][3];
        for (int i=0; i<=N; i++) {
            home[i][0] = 1;
            home[0][i] = 1;
        }
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=1; j<=N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i==1 && j==1) 
                    continue;
                if (i==1 && j==2 && home[1][2] != 1) {
                    dp[i][j][0] = 1;
                    continue;
                }
                if (home[i][j] != 1) {
                    if (home[i][j-1]!=1)
                        dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                    if (home[i-1][j]!=1)
                        dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                    if (home[i-1][j-1]!=1 && home[i-1][j]!=1 && home[i][j-1]!=1)
                        dp[i][j][2] = dp[i-1][j-1][0] +  dp[i-1][j-1][1] +  dp[i-1][j-1][2];
                }
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
        bf.close();
    }
}
