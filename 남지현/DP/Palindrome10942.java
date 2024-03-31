import java.io.*;

public class Main {
  
  private static boolean[][] solution(int N, int[] numbers, int M) {
    boolean[][] dp = new boolean[N+1][N+1];
    for (int i=1; i<=N; i++) {
      dp[i][i] = true;
    }
    for (int i=1; i<N; i++) {
      if (numbers[i]==numbers[i+1])
        dp[i][i+1] = true;
    }
    for(int i=2; i<N; i++) {
      for(int j = 1; j<=N-i; j++) {
        if(dp[j+1][j+i-1] && numbers[j] == numbers[j+i])
          dp[j][j+i] = true;
      }
    }
    return dp;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    String[] inputs = bf.readLine().split(" ");
    int [] arr= new int[N+1];
    for (int i=1; i<=N; i++) {
      arr[i] = Integer.parseInt(inputs[i-1]);
    }
    int M = Integer.parseInt(bf.readLine());
    int[][] questions = new int[M][2];
    for (int i=0; i<M; i++) {
      String[] arg = bf.readLine().split(" ");
      questions[i][0] = Integer.parseInt(arg[0]);
      questions[i][1] = Integer.parseInt(arg[1]);
    }
    boolean[][] result = solution(N, arr, M);
    StringBuilder str = new StringBuilder();
    for (int[] q: questions) {
      str.append(result[q[0]][q[1]]? 1: 0);
      str.append("\n");
    }
    System.out.println(str);
    bf.close();
  }
}
