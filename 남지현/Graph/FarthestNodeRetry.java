import java.util.*;
class Solution {
    int[] dist;
    boolean[] visited;
    Map<Integer, List<Integer>> graph;
    PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1]==arr2[1]? arr1[0]-arr2[0]: arr1[1]-arr2[1]);
    final int MAX = 50001;
    public int solution(int n, int[][] edge) {
        dist = new int[n+1];
        visited = new boolean[n+1];
        graph = new HashMap<>();
        Arrays.fill(dist, MAX);
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e: edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        pq.add(new int[]{1, 0});
        dist[1] = 0;
        while (! pq.isEmpty()) {
            int[] now = pq.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int next: graph.get(now[0])) {
                if (now[1]+1 < dist[next]) {
                    dist[next] = now[1]+1;
                    pq.add(new int[]{next, now[1]+1});
                }
            }
        }
        int max = -1;
        for (int i=2; i<=n; i++) {
            max = Math.max(dist[i], max);
        }
        int answer = 0;
        for (int i=2; i<=n; i++) {
            if (max == dist[i]) answer++;
        }
        return answer;
    }
}
