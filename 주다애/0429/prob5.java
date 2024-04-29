// 가장 먼 노드
import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList<>();
        // 그래프 초기화
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // 양방향 그래프 만들기
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        boolean[] visited = new boolean[n + 1];
        List<Integer> dist = new ArrayList<>();
        dist.add(0);
        visited[1] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            int start = node.start;
            int cost = node.cost;
            for(int v : graph.get(start)) {
                if(!visited[v]) {
                    q.offer(new Node(v, cost + 1));
                    visited[v] = true;
                    dist.add(cost + 1);
                }
            }
        }
        Collections.sort(dist);
        int max = dist.get(dist.size() - 1);
        for(int d : dist) {
            if(d == max) {
                answer++;
            }
        }
        return answer;
    }
    
    class Node {
        int start;
        int cost;
        Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
}
