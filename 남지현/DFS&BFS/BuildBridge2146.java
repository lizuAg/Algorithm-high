import java.util.*;
import java.io.*;

// 2146 다리 만들기

class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 각 섬의 테두리 점을 저장할 리스트
        List<List<int[]>> borders = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]==0 || visited[i][j]) continue;
                ArrayDeque<int[]> queue = new ArrayDeque<>();
                List<int[]> borderPoints = new ArrayList<>();
                queue.addLast(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] now = queue.pollFirst();
                    boolean isBorder = false;
                    for (int d=0; d<4; d++) {
                        int nx = now[0]+dx[d];
                        int ny = now[1]+dy[d];
                        if (nx>=0 && nx<N && ny>=0 && ny<N) {
                            if (map[nx][ny]==0) {
                                isBorder = true;
                            } else if (map[nx][ny]==1 && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.addLast(new int[]{nx, ny});
                            }
                        }
                    }
                    if (isBorder) {
                        // map의 가장자리를 제외한 섬의 테두리 점을 저장
                        borderPoints.add(now);
                    }
                }
                borders.add(borderPoints);
            }
        }
        int min = 201;
        for (int i=0; i<borders.size(); i++) {
            for (int j=i+1; j<borders.size(); j++) {
                for (int[] point1: borders.get(i)) {
                    for (int[] point2: borders.get(j)) {
                        min = Math.min(min, Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1])-1);
                    }
                }
            }
        }
        System.out.println(min);
    }
}
