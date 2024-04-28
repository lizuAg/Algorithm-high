import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];
        for (int i=1; i<=N; i++) {
            String[] arg = bf.readLine().split(" ");
            T[i] = Integer.parseInt(arg[0]);
            P[i] = Integer.parseInt(arg[1]);
        }
        for (int i=N; i>0; i--) {
            if (i+T[i]-1 <= N) {
                dp[i] = Math.max(dp[i+T[i]]+P[i], dp[i]);
            }
            dp[i-1] = dp[i];
        }
        System.out.println(dp[0]);
        bf.close();
    }
}
