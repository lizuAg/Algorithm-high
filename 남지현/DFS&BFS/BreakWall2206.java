import java.util.*;
import java.io.*;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0}); // x, y, depth, count
        visited[0][0][0] = true;
        while(! queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0]==N-1 && now[1]==M-1) {
                return now[2]+1;
            }
            for (int j=0; j<4; j++) {
                int nx = now[0]+dx[j];
                int ny = now[1]+dy[j];
                if (nx>=0 & nx<N && ny>=0 && ny<M && !visited[now[3]][nx][ny]) {
                    if (map[nx][ny]=='0') {
                        queue.add(new int[]{nx, ny, now[2]+1, now[3]});
                        visited[now[3]][nx][ny] = true;
                    } else {
                        if (now[3]==0) {
                            queue.add(new int[]{nx, ny, now[2]+1, now[3]+1});
                            visited[now[3]+1][nx][ny] = true;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new char[N][M];
        visited = new boolean[2][N][M];
        for (int i=0; i<N; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        System.out.println(bfs());
    }
}
