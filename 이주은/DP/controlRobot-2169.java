import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        getInput();

        dp[0][0] = map[0][0];
        for(int j=1; j<M; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
        }

        for(int i=1; i<N; i++) {
            //|
            for(int j=0; j<M; j++) {
                dp[i][j] = dp[i-1][j] + map[i][j];
            }
            //->
            int value = dp[i-1][0] + map[i][0];
            for(int j=1; j<M; j++) {
                value = Math.max(value, dp[i-1][j]) + map[i][j];
                dp[i][j] = Math.max(dp[i][j], value);
            }
            //<-
            value = dp[i-1][M-1] + map[i][M-1];
            for(int j=M-2; j>=0; j--) {
                value = Math.max(value, dp[i-1][j]) + map[i][j];
                dp[i][j] = Math.max(dp[i][j], value);
            }
        }
        
        System.out.println(dp[N-1][M-1]);
    }
    
    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        map = new int[N][M];
        dp = new int[N][M];
        
        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }        
    }
}
