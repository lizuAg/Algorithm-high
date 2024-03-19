//[BOJ] 도로검문 (https://www.acmicpc.net/submit/2307/75271884)

import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  //인접행렬리스트
  static ArrayList<ArrayList<Road>> graph = new ArrayList<>();
  //도로 통제를 위한 도로 리스트
  static List<Road> roadList = new ArrayList<>();

  static class Road implements Comparable<Road> {
    int node, cost;

    public Road(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
      return this.cost - o.cost;
    }
  }
  public static int dijkstra1() {
    PriorityQueue<Road> pq = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    pq.offer(new Road(1, 0));
    dist[1] = 0;

    while (!pq.isEmpty()) {
      Road road = pq.poll();
      int node = road.node;
      int cost = road.cost;

      if (dist[node] < cost) continue;

      for (Road nextRoad : graph.get(node)) {
        int nextNode = nextRoad.node;
        int nextCost = nextRoad.cost + cost;
        
        if (dist[nextNode] > nextCost) {
          dist[nextNode] = nextCost;
          pq.offer(new Road(nextNode, dist[nextNode]));
          roadList.add(new Road(node, nextNode));
        }
      }
    }
    return dist[N];
  }

  public static int dijkstra2(int closedStart, int closedEnd) {
    PriorityQueue<Road> pq = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    pq.offer(new Road(1, 0));
    dist[1] = 0;

    while (!pq.isEmpty()) {
      Road road = pq.poll();
      int node = road.node;
      int cost = road.cost;

      if (dist[node] < cost) continue;

      for (Road nextRoad : graph.get(node)) {
        int nextNode = nextRoad.node;
        int nextCost = nextRoad.cost + cost;
        if((node==closedStart && nextNode==closedEnd) || (node==closedEnd && nextNode==closedStart))
          continue;
        if (dist[nextNode] > nextCost) {
          dist[nextNode] = nextCost;
          pq.offer(new Road(nextNode, dist[nextNode]));
        }
      }
    }
    return dist[N];
  }

  public static void read() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<Road>());
    }

    for(int i = 0; i < M; i++){
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        graph.get(from).add(new Road(to, cost));
        graph.get(to).add(new Road(from, cost));
    }
  }

  public static void main(String[] args) throws IOException {
    int minTime, answer;
    read();
    minTime = dijkstra1();//도로통제가 없는 최단 소요시간
    answer = 0;//최대소요시간(답)

    for(Road closed : roadList) {
      int temp = dijkstra2(closed.node, closed.cost);

      //도로통제로 인하여 탈출을 완전 저지할 경우
      if(temp == Integer.MAX_VALUE){
        answer = -1;
        break;
      }
      else{
        answer = Math.max(answer, temp - minTime);
      }
    }
    System.out.println(answer);
  }
}
