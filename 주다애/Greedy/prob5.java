import java.util.*;

// 최소 신장 트리
// 크루스칼 알고리즘(기억 저편에 있던..)
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        // 가중치 오름차순으로 우선 순위 큐에 저장
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int[] cost : costs) {
            pq.add(new Edge(cost[0], cost[1], cost[2]));
        }

        // 초기 세팅 : 자기 자신의 부모 == 자기 자신
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(findParent(edge.node[0]) != findParent(edge.node[1])) {
                setParent(edge.node[0], edge.node[1]);
                answer += edge.cost;
            }
        }
        return answer;
    }

    private void setParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    // 최상위 부모 찾기
    private int findParent(int i) {
        if(parent[i] == i) {
            return i;
        }
        return findParent(parent[i]);
    }

    static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int cost;

        Edge(int a, int b, int cost) {
            this.node[0] = a;
            this.node[1] = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
