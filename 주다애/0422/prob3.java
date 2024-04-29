import java.util.*;

// 효울성 테스트 통과 못함
// 1. dist 2차원 -> 1차원
// 2. 미리 계산해서 배열릉 리턴해줌
class Solution {
    static List<List<Node>> graph = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] f : fares) {
            int start = f[0], end = f[1], cost = f[2];
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        
        // 배열로 받음
        int[] distFromS = dijkstra(s, n);
        int[] distFromA = dijkstra(a, n);
        int[] distFromB = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distFromS[i] != Integer.MAX_VALUE && distFromA[i] != Integer.MAX_VALUE && distFromB[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
            }
        }
        return answer;
    }
    
    static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.idx;
            
            for (Node next : graph.get(currentIndex)) {
                if (dist[next.idx] > dist[currentIndex] + next.cost) {
                    dist[next.idx] = dist[currentIndex] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }
    
    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
