import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
  
  final static int MAX = 1000000000;
  static List<int[]> used = new ArrayList<>();
  
  private static int solution(int N, int M, List<int[]> edges) {
    int delayedTime = -1;
    int shortenTime =-1;
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
    int[] dist = new int[N+1];
    boolean[] visited = new boolean[N+1];
    List<List<int[]>> graph = new ArrayList<>();
    for (int j=0; j<=N; j++) {
      graph.add(new ArrayList<>());
      dist[j] = MAX;
    }
    for (int j=0; j<M; j++) {
      int[] edge = edges.get(j);
      graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
      graph.get(edge[1]).add(new int[] {edge[0], edge[2]});
    }
    
    shortenTime = shortestPath(N, dist, pq, visited, graph);
    
    for (int[] tmp: used) {
      pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
      dist = new int[N+1];
      visited = new boolean[N+1];
      for (int j=1; j<=N; j++) {
        dist[j] = MAX;
      }
      delayedTime = Math.max(delayedTime, delayedPath(tmp, N, dist, pq, visited, graph));
    }
    return delayedTime==MAX? -1: delayedTime-shortenTime;
  }
  
  private static int shortestPath(int N, int[] dist, PriorityQueue<int[]> pq, boolean[] visited, List<List<int[]>> graph) {
    dist[1] = 0;
    pq.add(new int[] {1, 0});
    while (! pq.isEmpty()) {
      int[] current = pq.poll();
      if (visited[current[0]])
        continue;
      visited[current[0]] = true;
      for (int[] next : graph.get(current[0])) {
        if (dist[next[0]] > dist[current[0]] + next[1]) {
          dist[next[0]] = dist[current[0]] + next[1];
          pq.add(new int[]{next[0], dist[next[0]]});
          used.add(new int[]{current[0], next[0], next[1]});
        }
      }
    }
    return dist[N];
  }
  
  private static int delayedPath(int[] removedEdge, int N, int[] dist, PriorityQueue<int[]> pq, boolean[] visited, List<List<int[]>> graph) {
    dist[1] = 0;
    pq.add(new int[] {1, 0});
    while (! pq.isEmpty()) {
      int[] current = pq.poll();
      if (visited[current[0]])
        continue;
      visited[current[0]] = true;
      for (int[] next : graph.get(current[0])) {
        if (removedEdge[0]==current[0] && removedEdge[1]==next[0] && removedEdge[2]==next[1]) 
          continue;
        if (dist[next[0]] > dist[current[0]] + next[1]) {
          dist[next[0]] = dist[current[0]] + next[1];
          pq.add(new int[]{next[0], dist[next[0]]});
        }
      }
    }
    return dist[N];
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arg = Arrays.stream(bf.readLine().split(" ")).map(a -> Integer.parseInt(a)).collect(Collectors.toList());
    List<int[]> graph = new ArrayList<>();
    for (int i=0; i<arg.get(1); i++) {
      String[] edge = bf.readLine().split(" ");
      graph.add(new int[] {Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2])});
    }
    System.out.println(solution(arg.get(0), arg.get(1), graph));
    bf.close();
  }
}
