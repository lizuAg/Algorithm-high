import java.util.*;
import java.io.*;

class Main {
    static Map<Integer, List<Integer>> graph;
    static int[] dist;
    static boolean[] visited;
    static boolean isCycle;
    static Queue<Integer> queue = new LinkedList<>();

    private static void searchCycleDfs(int now, int prev) {
        visited[now] = true;
        for (int next: graph.get(now)) {
            if (visited[next] && prev!=next) {
                isCycle = true;
                dist[next] = 0;
                queue.add(next);
                break;
            } else if (!visited[next]) {
                searchCycleDfs(next, now);
                if (isCycle) {
                    if (dist[next]==0) {
                        isCycle = false;
                    } else {
                        dist[next]=0;
                        queue.add(next);
                    }
                    return;
                }
            }
        }
    }

    private static void calculateDistBfs() {
        int count=1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i=0; i<len; i++) {
                int node = queue.poll();
                for (int next: graph.get(node)) {
                    if (dist[next]!=-1) continue;
                    dist[next] = count;
                    queue.add(next);
                }
            }
            count++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        graph = new HashMap<>();
        for (int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        visited = new boolean[N+1];
        searchCycleDfs(1, 0);
        calculateDistBfs();
        StringBuilder str = new StringBuilder();
        for (int i=1; i<=N; i++) {
            str.append(dist[i]).append(" ");
        }
        System.out.println(str.toString());
        bf.close();
    }
}
