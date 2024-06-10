import java.util.*;
import java.io.*;

class Main {
    static int C, N;
    static int[] costs;
    static int[] customers;
    
    public static void main(String[] args) throws Exception {
        input();

        int answer = 0;
        int[] dp = new int[C+100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        
        for(int i=1; i<=C; i++) { //고객 제한
            for(int j=0; j<N; j++) {
                if(customers[j] <= i) {
                    if(dp[i-customers[j]] != Integer.MAX_VALUE)
                        dp[i] = Math.min(costs[j] + dp[i-customers[j]], dp[i]);
                }
            }
        }

        answer = dp[C];
        
        for(int i=C+1; i<C+100; i++) { //고객 제한
            for(int j=0; j<N; j++) {
                if(customers[j] <= i) {
                    if(dp[i-customers[j]] != Integer.MAX_VALUE)
                        dp[i] = Math.min(costs[j] + dp[i-customers[j]], dp[i]);

                    answer = Math.min(answer, dp[i]);
                }
            }
        }

        System.out.println(answer);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        C = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);

        costs = new int[N+1];
        customers = new int[N+1];
        
        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            costs[i] = Integer.parseInt(line[0]);
            customers[i] = Integer.parseInt(line[1]);
        }
    }
}
