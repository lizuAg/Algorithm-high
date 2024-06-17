import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 1;
        
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                bw.flush();
                return;
            }

            map = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] line = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            bw.write("Problem "+T+": "+solve()+"\n");
            T++;
        }
    }

    static int solve() throws IOException {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[2] - arr2[2]);
        int[][] loss = new int[N][N];
        
        for(int i = 0 ; i<N; i++) {
            for(int j=0; j<N; j++) {
                loss[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.add(new int[] {0, 0, map[0][0]});

        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            int r = curr[0];
            int c = curr[1];
            int l = curr[2];

            if(l >= loss[r][c])
               continue;
            
            loss[r][c] = l;
            
            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if(loss[nr][nc] > loss[r][c] + map[nr][nc]) {
                    pq.add(new int[] {nr, nc, loss[r][c] + map[nr][nc]});
                }
            }
        }

        return loss[N-1][N-1];
    }
}
