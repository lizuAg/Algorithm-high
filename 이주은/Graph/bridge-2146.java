import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] dist;
    static int[][] cities;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        getInput();
        markCity();
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int k=0; k<4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
                if(dist[nr][nc] == -1) {
                    queue.add(new int[] {nr, nc, curr[2]});
                    
                    cities[nr][nc] = curr[2];
                    dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                }
                else if(cities[nr][nc] != curr[2]) {
                    answer = Math.min(answer, dist[nr][nc] + dist[curr[0]][curr[1]]);
                }
            }
        }
    }

    public static void markCity() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int city = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dist[i][j] == 0 && !visited[i][j]) {
                    q.add(new int[] {i, j, ++city});
                }

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    cities[curr[0]][curr[1]] = city;
                    queue.add(curr);
                    
                    for(int k=0; k<4; k++) {
                        int nr = curr[0] + dr[k];
                        int nc = curr[1] + dc[k];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                            continue;
                        if(dist[nr][nc] == 0 && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.add(new int[] {nr, nc, city});
                        }
                    }
                }
            }
        }
    }

    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        cities = new int[N][N];
        
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                if(line[j].equals("0"))
                    dist[i][j] = -1;
            }
        }
    }
}
