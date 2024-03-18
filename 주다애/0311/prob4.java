import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파티(골드 3)
public class Main {
    static List<ArrayList<Node>> graph;
    static int n;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dist = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(w, cost));
        }
        for(int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int ds = dist[i][x] + dist[x][i];
            if(ds > max) {
                max = ds;
            }
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        boolean[] check = new boolean[n + 1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist[start], inf);

        dist[start][start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 본인 -> 본인 : 거리 0
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int now = pq.poll().idx;

            if(check[now]) continue;
            check[now] = true;

            for(Node next : graph.get(now)) {
                // 현재 저장된 거리보다 짧으면
                if(dist[start][next.idx] > dist[start][now] + next.cost) {
                    // dist 배열 업데이트 해주고
                    dist[start][next.idx] = dist[start][now] + next.cost;
                    // 우선순위 큐에 넣어준다.
                    pq.offer(new Node(next.idx, dist[start][now] + next.cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
