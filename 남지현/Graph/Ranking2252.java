import java.util.*;
import java.io.*;

// 줄 세우기

class Main {
  
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int[] degree = new int[N+1];
        for (int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            degree[B]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            if (degree[i]==0) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            answer.add(now);
            for (int next: graph.get(now)) {
                degree[next]--;
                if (degree[next]==0) {
                    queue.addLast(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int e: answer) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);
    }
}
