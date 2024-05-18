import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        
        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        while(true) {
            if (room[x][y] == 0) {
                room[x][y] = 2;
                count++;
            }
            int i;
            for (i=0; i<4; i++) {
                dir = (dir + 3)%4;
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if (nx>=0 && nx<N && ny>=0 && ny<M && room[nx][ny]==0) {
                    x = nx;
                    y = ny;
                    break;
                }
            }
            if (i == 4) {
                int nx = x-dx[dir];
                int ny = y-dy[dir];
                if (nx>=0 && nx<N && ny>=0 && ny<M) {
                    if (room[nx][ny]!=1) {
                        x = nx;
                        y = ny;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
