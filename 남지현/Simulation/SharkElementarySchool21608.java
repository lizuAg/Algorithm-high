import java.util.*;
import java.io.*;

public class Main {
  static Set<Integer>[] friends;
  static List<int[]> candidates;
  static int[][] seats;
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  
  private static int solution(int N, int[] seq, Set<Integer>[] friends) {
    int NxN = N*N;
    int[][] points = new int[NxN+1][2];
    seats = new int[N][N];
    for (int now: seq) {
      candidates = new ArrayList<>();
      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
          if (seats[x][y] ==0 )
            candidates.add(new int[]{x, y, countFriends(N, x, y, now), countEmptySeat(N, x, y)});
        }
      }
      Collections.sort(candidates, (o1, o2) -> {
        int[] arr1 = (int[]) o1;
        int[] arr2 = (int[]) o2;
        if (arr1[2]==arr2[2]) {
          if (arr1[3]==arr2[3])
            return arr1[0]==arr2[0]? arr1[1]-arr2[1] : arr1[0]-arr2[0];
          else 
            return arr2[3]-arr1[3];
        } else {
          return arr2[2]-arr1[2];
        }
      });
      int[] win = candidates.get(0);
      seats[win[0]][win[1]] = now;
      points[now] = new int[]{win[0], win[1]};
    }
    int answer=0;
    for (int i = 1; i <= NxN; i++) {
      answer += score(countFriends(N, points[i][0], points[i][1], i));
    }
    return answer;
  }
  
  private static int countFriends(int N, int x, int y, int student) {
    int count=0;
    for (int[] d: dir) {
      if (x+d[0]>=0 && x+d[0]< N && y+d[1]>=0 && y+d[1]< N) {
        if (friends[student].contains(seats[x+d[0]][y+d[1]])) {
          count++;
        }
      }
    }
    return count;
  }
  
  private static int countEmptySeat(int N, int x, int y) {
    int count=0;
    for (int[] d: dir) {
      if (x+d[0]>=0 && x+d[0]<N && y+d[1]>=0 && y+d[1]<N && seats[x+d[0]][y+d[1]]==0) {
        count++;
      }
    }
    return count;
  }
  
  private static int score(int number) {
    if (number == 2) return 10;
    if (number == 3) return 100;
    if (number == 4) return 1000;
    else return number;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] turn = new int[N*N];
    friends = new Set[N*N+1];
    for (int i = 1; i <= N*N; i++) {
      friends[i] = new HashSet<>();
    }
    for (int i = 0; i < N*N; i++) {
      String[] input = bf.readLine().split(" ");
      turn[i] = Integer.parseInt(input[0]);
      for (int j = 1; j < 5; j++) {
        friends[turn[i]].add(Integer.parseInt(input[j]));
      }
    }
    System.out.println(solution(N, turn, friends));
    bf.close();
  }
}
