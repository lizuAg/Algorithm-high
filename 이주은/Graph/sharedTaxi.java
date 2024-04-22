//[프로그래머스]합승 택시 요금(https://school.programmers.co.kr/learn/courses/30/lessons/72413)
//다익스트라

import java.util.*;

class Road implements Comparable<Road> {
    int node, cost;
        
    Road(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
        
    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}

class Solution {
    List<List<Road>> graph = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Road>());
        
        for(int i=0; i<fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            
            graph.get(from).add(new Road(to, cost));
            graph.get(to).add(new Road(from, cost));
        }
        
        int[] startS = dijkstra(s, n);
        int[] startA = dijkstra(a, n);
        int[] startB = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++) {
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int N) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(start, 0));
        
        while(!pq.isEmpty()) {
            Road curr = pq.poll();
            for(Road next: graph.get(curr.node)) {
                int to = next.node;
                int cost = curr.cost + next.cost;
                if (dist[to] > cost) {
                    dist[to] = cost;
                    pq.offer(new Road(to, dist[to]));
                }
            }
        }
        return dist;
    }
}
