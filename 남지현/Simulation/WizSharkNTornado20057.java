import java.io.*;

public class WizSharkNTornado20057 {
  
  public static int solution(int N, int[][] A) {
    int out = 0;
    int X = N/2+1;
    int Y = N/2+1;
    int[][] dir  = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; 
    int[][] percentages = {{0, 0, 2, 0, 0}, {0, 10, 7, 1, 0}, {5, 0, 0, 0, 0}, {0, 10, 7, 1, 0}, {0, 0, 2, 0, 0}};
    int idx=0;
    int repeat = 0;
    int num = 1;
    boolean isOver = false;
    while (! isOver) {
      if (num == N) {
        isOver = true;
        num = N-1;
      }
      for (int j=0; j<num; j++) {
        X += dir[idx][0];
        Y += dir[idx][1];
        int sum=0;
        for (int r=-2; r<3; r++) {
          for (int c=-2; c<3; c++) {
            int add = percentOf(A[X][Y], percentages[r+2][c+2]);
            if (X+r>0 && X+r<=N && Y+c>0 && Y+c<=N) {
              A[X+r][Y+c] += add;
            } else {
              out += add;	
            }
            sum+= add;
          }
        }
        if (X+dir[idx][0]>0 && X+dir[idx][0]<=N && Y+dir[idx][1]>0 && Y+dir[idx][1]<=N) {
          A[X+dir[idx][0]][Y+dir[idx][1]] += A[X][Y]-sum;
        }
        else {
          out += A[X][Y]-sum;
        }
        A[X][Y]=0;
      }
      idx = (idx+1)%4;
      percentages = rotate(percentages);
      num  = repeat%2==0 ? num : num+1;
      repeat++;
    }
    return out;
  }
  
  private static int[][] rotate(int[][] before) {
    int[][] after = new int[5][5];
    for (int i=0; i<5; i++) {
      for (int j=0; j<5; j++) {
        after[i][j] = before[j][4-i];
      }
    }
    return after;
  }

  private static int percentOf(int x, int rate) {
    return x*rate/100;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[][] A = new int[N+1][N+1];
    for (int i=1; i<=N; i++) {
      String[] s = bf.readLine().split(" ");
      for (int j=1; j<=N; j++) {
        A[i][j] = Integer.parseInt(s[j-1]);
      }
    }
    System.out.println(solution(N, A));
    bf.close();
  }
}
