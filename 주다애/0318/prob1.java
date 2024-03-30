import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 도로검문(골드 1)
// 도저히 메모리 초과를 해결하지 못하겠습니다..
// 주은님 아이디어로 해결 완료
public class BaekJoon2307 {
    static int N;
    static int M;
    static List<List<Node>> graph;
    static int inf = Integer.MAX_VALUE;
    static PriorityQueue<Node> candidate;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        candidate = new PriorityQueue<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(a, b, cost));
            graph.get(b).add(new Node(b, a, cost)); // 양방향 도로
        }
        candidate.offer(new Node(1, 1, 0));
        int min = dijkstra(0, 0); // 최초의 최단 경로

        int maxDelay = 0;
//        for (int i = 1; i <= N; i++) {
//            for (Node node : graph.get(i)) {
//                int delay = dijkstra(i, node.end);
//                maxDelay = Math.max(maxDelay, delay);
//            }
//        }
        while(!candidate.isEmpty()) {
            Node node = candidate.poll();
            int delay = dijkstra(node.start, node.end);
            maxDelay = Math.max(maxDelay, delay);
        }
        if (maxDelay == inf) {
            System.out.println(-1);
        } else {
            System.out.println(maxDelay - min);
        }
    }

    private static int dijkstra(int bStart, int bEnd) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, inf);

        dist[1] = 0;
        pq.offer(new Node(1, 1, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.end;

            if (check[now]) continue;
            check[now] = true;

            for (Node n : graph.get(now)) {
                int newCost = dist[now] + n.cost;
                if ((n.start == bStart && n.end == bEnd)) continue; // 차단된 도로인 경우 스킵

                if (newCost < dist[n.end]) {
                    dist[n.end] = newCost;
                    pq.offer(new Node(n.start, n.end, newCost));
                    if(cnt == 0) {
                        candidate.offer(new Node(n.start, n.end, newCost));
                    }
                }
            }
        }
        cnt++;
        return dist[N];
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
