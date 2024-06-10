//백준 1495번 기타리스트(https://www.acmicpc.net/submit/1495/79456108)

import java.util.*;
import java.io.*;

class Main {
    static int N, S, M;
    static int[] v;
    static boolean[][] dp;
    
    public static void main(String[] args) throws IOException {
        getInput();

        System.out.println(solve());
    }

    static int solve() {
        dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i=1; i<=N; i++) {
            boolean flag = false;
            
            for(int j=0; j<=M; j++) {
                if(dp[i-1][j]){
                    int next = j + v[i];
                    if(next >= 0 && next <= M)
                        dp[i][next] = true;
                    next = j - v[i];
                    if(next >= 0 && next <= M)
                        dp[i][next] = true;

                    flag = true;
                }
            }
            if(!flag)
                return -1;
        }
        
        for(int i=M; i>=0; i--) {
            if(dp[N][i])
                return i;
        }
        return -1;
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        M = Integer.parseInt(line[2]);

        v = new int[N+1];
        line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            v[i+1] = Integer.parseInt(line[i]);
        }
    }
}
