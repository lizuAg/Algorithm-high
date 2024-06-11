import java.util.*;
import java.io.*;

// 최소비용 구하기

class Main {
    
    static final int MAX = 1_000_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        for (int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }
        StringTokenizer st;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                .add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        st = new StringTokenizer(bf.readLine());
        int dep = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[dep] = 0;
        pq.add(new Edge(dep, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.destination]) continue;
            visited[now.destination] = true;
            for (int[] edge: graph.get(now.destination)) {
                if (dist[edge[0]] > dist[now.destination]+edge[1]) {
                    dist[edge[0]] = dist[now.destination]+edge[1];
                    pq.add(new Edge(edge[0], dist[edge[0]]));
                }
            }
        }
        System.out.println(dist[dst]);
    }

    static class Edge implements Comparable<Edge>{
        int destination;
        int value;

        Edge(int destination, int value) {
            this.destination = destination;
            this.value = value;
        }

        public int compareTo(Edge edge) {
            if (this.value<edge.value) return -1;
            else if (this.value==edge.value) return 0;
            else return 1;
        }
    }
}
