import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
  
  private static PriorityQueue<Edge> pq;
  private static boolean[] visited;
  final static int MAX = 1000000000;
  
  private static int solution(int N, int M, int X, Map<Integer, List<int[]>> graph) {
    int[] startFrom = new int[N+1];
    for (int dep=1; dep<N+1; dep++) {
      int[] dist = new int[N+1];
      for (int i=1; i<N+1; i++) {
        dist[i] = MAX;
      }
      dist[dep] = 0;
      visited = new boolean[N+1];
      pq = new PriorityQueue<>();
      pq.add(new Edge(dep, 0));
      while (! pq.isEmpty()) {
        Edge current = pq.poll();
        if (visited[current.vertex]) 
          continue;
        visited[current.vertex] = true;
        for (int[] next: graph.get(current.vertex)) {
          if (dist[next[0]] > dist[current.vertex] + next[1]) {
            dist[next[0]] = dist[current.vertex] + next[1];
            pq.add(new Edge(next[0], dist[next[0]]));
          }
        }
      }
      startFrom[dep] = dist[X];
    }
    
    visited = new boolean[N+1];
    int[] comeBack = new int[N+1];
    for (int i=1; i<N+1; i++) {
      comeBack[i] = MAX;
    }
    comeBack[X] = 0;
    pq = new PriorityQueue<>();
    pq.add(new Edge(X, 0));
    while (! pq.isEmpty()) {
      Edge current = pq.poll();
      if (visited[current.vertex])
        continue;
      visited[current.vertex] = true;
      for (int[] next: graph.get(current.vertex)) {
        if (comeBack[next[0]] > comeBack[current.vertex] + next[1]) {
          comeBack[next[0]] = comeBack[current.vertex] + next[1];
          pq.add(new Edge(next[0], comeBack[next[0]]));
        }
      }
    }
    int max = 0;
    for (int i=1; i<N+1; i++) {
      max =  Math.max(max, startFrom[i]+comeBack[i]);
    }
    return max;
  }
  
  static class Edge implements Comparable<Edge> {
    int vertex;
    int value;
    
    Edge(int vertex, int value) {
      this.vertex = vertex;
      this.value = value;
    }
    
    @Override
    public int compareTo(Edge node) {
      return this.value == node.value? this.vertex-node.vertex: this.value-node.value;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arg = Arrays.stream(bf.readLine().split(" ")).map(a -> Integer.parseInt(a)).collect(Collectors.toList());
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int i=1; i<=arg.get(0); i++) {
      map.put(i, new ArrayList<>());
    }
    for (int i=0;  i<arg.get(1); i++) {
      String[] buffer = bf.readLine().split(" ");
      map.get(Integer.parseInt(buffer[0])).add(new int[]{Integer.parseInt(buffer[1]), Integer.parseInt(buffer[2])});
    }
    System.out.println(solution(arg.get(0), arg.get(1), arg.get(2), map));
  }
}
