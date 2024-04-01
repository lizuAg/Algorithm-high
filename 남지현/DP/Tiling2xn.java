import java.io.*;

public class Main {
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int mod = 10007;
    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 2;
    for (int i=3; i<=n; i++) {
      dp[i] = (dp[i-1]+dp[i-2])%mod;
    }
    System.out.println(dp[n]);
    bf.close();
  }
}
