import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] nums;
    static boolean[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        dp = new boolean[N+1][N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        setDp();
        
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E])
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.flush();
    }

    // dp[S][E]가 true : S~E가 팰린드롬.
    // dp[S][E]가 true <- S == E && dp[S-1][E-1]
    
    private static void setDp() {
         for(int i=1; i<=N; i++){
             dp[i][i] = true;

             if(nums[i-1] == nums[i]) {
                 dp[i-1][i] = true;
             }
         }

        for (int i=2; i<N; i++) {
            for (int j=1; j<=N-i; j++) {
                if (nums[j] == nums[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                }
            }
        }
    }
}
