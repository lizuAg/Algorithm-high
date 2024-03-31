import java.io.*;
import java.util.*;

public class Main {
  
  static final int MAX = 200000;
  
  private static int oneZeroBFS(int N, int K) {
    if (N >= K)
      return N-K;
    Deque<int[]> dq = new LinkedList<>();
    int[] times = new int[MAX+1];
    Arrays.fill(times, MAX);
    times[N] = 0;
    dq.add(new int[]{N, 0});
    while (! dq.isEmpty()) {
      int[] now = dq.pollFirst();
      if (times[now[0]] < now[1])
        continue;
      if (now[0]-1 > 0 && times[now[0]-1] > now[1]+1) {
        times[now[0]-1] = now[1]+1;
        dq.addLast(new int[]{now[0]-1, now[1]+1});
      }
      if (now[0]+1 <= MAX && times[now[0]+1] > now[1]+1) {
        times[now[0]+1] = now[1]+1;
        dq.addLast(new int[]{now[0]+1, now[1]+1});
      }
      if (now[0]*2 <= MAX && times[now[0]*2] > now[1]) {
        times[now[0]*2] = now[1];
        dq.addFirst(new int[]{now[0]*2, now[1]});
      }
    }
    return times[K];
  }
  
  private static int dijkstra(int N, int K) {
    if (N >= K) 
      return N-K;
    PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1]-arr2[1]);
    int[] times = new int[MAX+1];
    Arrays.fill(times, MAX);
    times[N] = 0;
    pq.add(new int[]{N, 0});
    while (! pq.isEmpty()) {
      int[] now = pq.poll();
      if (times[now[0]] < now[1])
        continue;
      if (now[0]-1 > 0 && times[now[0]-1] > now[1]+1) {
        times[now[0]-1] = now[1]+1;
        pq.add(new int[]{now[0]-1, now[1]+1});
      }
      if (now[0]+1 <= MAX && times[now[0]+1] > now[1]+1) {
        times[now[0]+1] = now[1]+1;
        pq.add(new int[]{now[0]+1, now[1]+1});
      }
      if (now[0]*2 <= MAX && times[now[0]*2] > now[1]) {
        times[now[0]*2] = now[1];
        pq.add(new int[]{now[0]*2, now[1]});
      }
    }
    return times[K];
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] arg = bf.readLine().split(" ");
    System.out.println(dijkstra(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
    System.out.println(oneZeroBFS(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
  }
}
