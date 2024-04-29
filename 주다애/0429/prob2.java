import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 서울 지하철 2호선(골드 3)
public class Main {
    static List<List<Integer>> graph;
    static int N;
    static boolean[] visited;
    static List<Integer> cycleList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();
        for(int i = 1; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        cycleList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        // 그래프 만들기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        // 순환선에 속하는 정점 구하기
        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            if((hasCycle(i, -1))) {
                cycleList.add(i);
            }
        }
        // 순환선 사이 거리 구하기
        for(int i = 1; i <= N; i++) {
            if(cycleList.contains(i)) {
                res.add(0);
                continue;
            }
            visited = new boolean[N + 1];
            visited[i] = true;
            res.add(getDist(i, 1));
        }
        // 결과 출력
        for(int dist : res) {
            System.out.print(dist + " ");
        }
    }

    private static boolean hasCycle(int v, int before) {
        for(int station : graph.get(v)) {
            if(!visited[station]) {
                visited[station] = true;
                hasCycle(station, v);
            }
            else if(before != station) {
                return true;
            }
        }
        return false;
    }

    private static int getDist(int v, int d) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{v,d});
        while(!q.isEmpty()) {
            int[] t = q.poll();
            int cv = t[0];
            int cd = t[1];
            for(int station : graph.get(cv)) {
                if(cycleList.contains(station)) {
                    return cd;
                }
                if(!visited[station]) {
                    visited[station] = true;
                    q.offer(new int[]{station, cd + 1});
                }
            }
        }
        return 0;
    }
}
