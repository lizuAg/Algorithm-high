//BOJ 파이프 옮기기1 (https://www.acmicpc.net/submit/17070/77625583)

import java.util.*;
import java.io.*;

class Main {
    static int[][][] dp;
    static boolean[][] map;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][N][3]; //dp[i][j][k] :i, j칸에 (0: 가로, 대각선: 1, 세로:2) 로 파이프 끝을 놓는 경우의 수
        map = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = line[j].equals("1");
            }
        }

        dp[0][1][0] = 1;
        System.out.println(solve());
    }
    public static int solve() {
        for(int i=0; i<N; i++) {
            for(int j=1; j<N; j++) { //1열은 파이프 끝이 올 수 없다.
                
                if(map[i][j]) continue; //벽이면 X 가로로 놓으려면 대각선 or 가로
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];

                if(i==0) continue; //벽도 아니고 && 세로로 놓으려면 2행부터 가능
                dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];

                if(map[i-1][j] || map[i][j-1]) continue; //대각선을 놓기 위한 빈칸 확
                dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }
        return dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
    }
}
