import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 녹색 옷 입은 애가 젤다지?(골드 4)
public class BaekJoon4485 {
    static int N;
    static int[][] zelda;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();
        while((N = Integer.parseInt(br.readLine())) != 0) {
            zelda = new int[N][N];
            StringTokenizer st;
            // 입력
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    zelda[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res.add(bfs(0, 0));
        }
        int turn = 1;
        for(int r : res) {
            System.out.println("Problem " + turn++ + ": "  + r);
        }
    }

    private static int bfs(int x, int y) {
        boolean[][] visited = new boolean[N + 1][N + 1];
        int[][] dist = new int[N + 1][N + 1];
        // 2차원 배열은 1차원 배열씩 초기화 해주어야 한다.
        for(int [] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        // 0이 아니라 값으로 설정
        dist[x][y] = zelda[0][0];
        // 값으로 오름차순(람다 식)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{x, y, zelda[x][y]});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == N - 1 && now[1] == N - 1) break;
            if(visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                if(!canMove(nx, ny)) continue;
                if(dist[nx][ny] > dist[now[0]][now[1]] + zelda[nx][ny]) {
                    dist[nx][ny] = dist[now[0]][now[1]] + zelda[nx][ny];
                    pq.offer(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    private static boolean canMove(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
