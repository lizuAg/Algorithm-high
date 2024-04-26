import java.util.*;

class Solution {
	Map<Integer, List<int[]>> graph = new HashMap<>();
    static final int MAX = Integer.MAX_VALUE;
    
    // 1. 다익스트라를 이용한 풀이
    public int solution1(int n, int s, int a, int b, int[][] fares) {
        initGraph(n, fares);
        int[] S = new int[n+1];
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        dijkstra(s, S);
        dijkstra(a, A);
        dijkstra(b, B);
        int answer = MAX;
        for (int i=1; i<=n; i++) {
            answer = Math.min(answer, S[i]+A[i]+B[i]);
        }
        return answer;
    }
    
    private void dijkstra(int start, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1]==arr2[1]? arr1[0]-arr2[0]: arr1[1]-arr2[1]);
        boolean[] visited = new boolean[dist.length];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll(); 
            if (visited[now[0]]) 
                continue;
            visited[now[0]] = true;
            for (int[] next: graph.get(now[0])) {
                if (dist[now[0]] + next[1] < dist[next[0]]) {
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
    }
    
    private void initGraph(int n, int[][] fares) {
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] fare: fares) {
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
    }

    // 2. 플로이드-워셜을 이용한 풀이
    public int solution2(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
        for (int[] fare: fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (dist[i][k]+dist[k][j]>=0 && dist[i][j]>dist[i][k]+dist[k][j]) {
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        int answer = MAX;
        for (int i=1; i<=n; i++) {
            answer = Math.min(answer, dist[s][i]+dist[i][a]+dist[i][b]);
        }
        return answer;
    }
}
