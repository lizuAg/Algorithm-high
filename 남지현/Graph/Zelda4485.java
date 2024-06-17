import java.util.*;
import java.io.*;

// boj 4485: 녹색 옷 입은 애가 젤다지?

class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int MAX = 150_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[][] map;
        int[][] dist;
        StringTokenizer st;
        PriorityQueue<int[]> pq;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while ((N=Integer.parseInt(bf.readLine())) > 0) {
            map = new int[N][N];
            dist = new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], MAX);
            }
            pq = new PriorityQueue<>((arr1, arr2) -> arr1[2]-arr2[2]);
            pq.add(new int[]{0, 0, map[0][0]});
            dist[0][0] = map[0][0];
            while (! pq.isEmpty()) {
                int[] point = pq.poll();
                if (point[0]==N-1 && point[1]==N-1) break;
                for (int d=0; d<4; d++) {
                    int nx = point[0]+dx[d];
                    int ny = point[1]+dy[d];
                    if (nx>=0 && nx<N && ny>=0 && ny<N && dist[nx][ny]>dist[point[0]][point[1]]+map[nx][ny]) {
                        dist[nx][ny] = dist[point[0]][point[1]]+map[nx][ny];
                        pq.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
            sb.append("Problem ").append(count).append(": ").append(dist[N-1][N-1]).append("\n");
            count++;
        }
        System.out.print(sb);
    }
}
