import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 모든 노드 탐색해서 자식 개수 찾기 -> 메모리 초과
// 2. 위상 정렬
public class BaekJoon2252 {
    static List<List<Integer>> graph;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            inDegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            // 진입 차수가 0인 노드 -> 최상위 노드만 일단 추가한다.
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (int next : graph.get(now)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}
