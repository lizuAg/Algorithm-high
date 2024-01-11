import java.io.*;
import java.util.*;

class Main {
    static int[][][] map;
    static boolean[][][] visited;
    static int M, N, H;
    static Deque<int[]> queue = new LinkedList<int[]>();
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};
    static int[] dn = {0, 0, 0, 0, -1, 1};

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] hnm = queue.poll();
            int h = hnm[0], n = hnm[1], m = hnm[2];

            for(int i=0; i<6; i++){
                int nextH = h + dh[i], nextM = m + dm[i], nextN = n + dn[i];

                if(checkOutIndex(nextH, nextN, nextM) && map[nextH][nextN][nextM] != -1 && !visited[nextH][nextN][nextM]){
                    int[] loc = {nextH, nextN, nextM};
                    queue.add(loc);
                    visited[nextH][nextN][nextM] = true;
                    map[nextH][nextN][nextM] = map[h][n][m] + 1;
                }
            }
        }
    }

    public static boolean checkOutIndex(int h, int n, int m){
        return h >= 0 && h < H && m >= 0 && m < M && n >= 0 && n < N;      
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); //가로 칸 수
        N = Integer.parseInt(input[1]); //세로 칸 수
        H = Integer.parseInt(input[2]); //상자 수

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int h=0; h<H; h++)
            for(int n=0; n<N; n++){
                input = br.readLine().split(" ");

                for(int m=0; m<M; m++)
                    map[h][n][m] = Integer.parseInt(input[m]);
            }

        br.close();

        for(int h=0; h<H; h++)
            for(int n=0; n<N; n++)
                for(int m=0; m<M; m++){
                    if(map[h][n][m] == 1){
                        int[] hnm = {h, n, m};
                        queue.add(hnm);
                        visited[h][n][m] = true;
                    }
                }
        bfs();

        int max = 1;
        for(int h=0; h<H; h++)
            for(int n=0; n<N; n++)
                for(int m=0; m<M; m++){
                    if(map[h][n][m] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if(map[h][n][m] > max)
                        max = map[h][n][m];
                }

    System.out.print(max-1);
    }
}
