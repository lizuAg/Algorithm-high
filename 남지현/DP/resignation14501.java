import java.io.*;

public class Main {
  
  private static int solution (int N, int[] T, int[] P) {
    int[] dp = new int[N+2];
    for (int i=N; i>0; i--) {
      if (i+T[i]-1>0 && i+T[i]-1<=N) {
        dp[i] = Math.max(dp[i+T[i]]+P[i], dp[i]);
      }
      dp[i-1] = dp[i];
    }
    return dp[0];
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] T = new int[N+1];
    int[] P = new int[N+1];
    for (int i=1; i<=N; i++) {
      String[] input = bf.readLine().split(" ");
      T[i] = Integer.parseInt(input[0]); 
      P[i] = Integer.parseInt(input[1]);
    }
    System.out.println(solution(N, T, P));
    bf.close();
  }
}
