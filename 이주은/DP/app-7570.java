import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] memories;
    static int[] costs;
    static int[][] dp;
    static int sum;
    
    public static void main(String[] args) throws IOException {
        getInput();
        
        System.out.print(solve());
    }

    public static int solve() {
            for(int i=0; i<=sum; i++) {//sum은 최대 비활성화 비용, i만큼 비용을 지불할 때 확보하는 최대 메모리를 찾는다. //i=0부터 ci=0인 앱이 있기 때문에..
            for(int j=1; j<=N; j++) { //앱 하나씩 확인
                int m = memories[j-1];
                int c = costs[j-1];

                if(i < c) //비활성화 비용이 비쌈. X
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = Math.max(dp[i-c][j-1] + m, dp[i][j-1]);
            }
            if(dp[i][N] >= M)
                return i;
        }

        return 0;
    }

    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        memories = new int[N];
        costs = new int[N];
        
        line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            memories[i] = Integer.parseInt(line[i]);
        }

        line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            costs[i] = Integer.parseInt(line[i]);
            sum += costs[i];
        }

        dp = new int[sum+1][N+1];
    }
}
