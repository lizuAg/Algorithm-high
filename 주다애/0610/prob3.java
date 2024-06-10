import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기(골드 5)
// 다익스트라
public class BaekJoon1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        // graph 초기화 -> 0 ~ N까지 인덱스 주의
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        // graph 만들기
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        // 출발점의 도시번호
        int start = Integer.parseInt(st.nextToken());
        // 도착점의 도시번호
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // 나 -> 나 : 거리=0
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int now = pq.poll().end;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node n : graph.get(now)) {
                int next = n.end;
                if(dist[next] > dist[now] + n.cost) {
                    dist[next] = dist[now] + n.cost;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
