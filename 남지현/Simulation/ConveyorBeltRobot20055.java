import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  static int[] belt;
  static boolean[] robots;
  
  private static int solution(int N, int K, int[] A) {
    int stage = 0;
    belt = new int[N+N+1];
    System.arraycopy(A, 0, belt, 1, N+N);
    robots = new boolean[N+N+1];
    while (true) {
      stage++;
      moveBelt(N+N);
      if (robots[N+1]) {
        robots[N+1] = false;
      }
      if (robots[N]) {
        robots[N] = false;
      }
      for (int i=N-1; i>0; i--) {
        if (belt[i+1] > 0 && robots[i] && !robots[i+1]) {
          robots[i+1] = true;
          robots[i] = false;
          belt[i+1]--;
        }
      }
      if (belt[1] > 0) {
        robots[1] = true;
        belt[1]--;
      }
      if (quit(N, K))
        break;
    }
    return stage;
  }
  
  private static boolean quit(int N, int K) {
    int count=0;
    for (int i=1; i<N+N+1; i++) {
      if (belt[i]==0)
        count++;
    }
    return count >= K;
  }
	
  private static void moveBelt(int Nx2) {
    int tmpDurability = belt[Nx2];
    boolean tmpRobotYn = robots[Nx2];
    for (int i=Nx2; i>0; i--) {
      belt[i] = belt[i-1];
      robots[i] = robots[i-1];
    }
    belt[1] = tmpDurability;
    robots[1] = tmpRobotYn;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arg = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    int[] durabilities = new int[arg.get(0)+arg.get(0)];
    String[] input = bf.readLine().split(" ");
    for (int i=0; i<arg.get(0)+arg.get(0); i++) {
      durabilities[i] = Integer.parseInt(input[i]);
    }
    System.out.println(solution(arg.get(0), arg.get(1), durabilities));
    bf.close();
    
  }

}
