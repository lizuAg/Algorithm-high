//SWEA 파리퇴치 3

import java.io.*;
import java.util.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
    static int[] dx1 = {-1, 1, 0, 0};
    static int[] dy1 = {0, 0, -1, 1};
     
    static int[] dx2 = {-1, 1, -1, 1};
    static int[] dy2 = {-1, 1, 1, -1};
     
    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {           
            bw.write("#"+test_case+" "+solve()+"\n");
        }
        bw.flush();
    }
     
    public static int solve() throws Exception {
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
         
        int[][] map = new int[N][N];
         
        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
         
        int answer = 0;
         
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                answer = Math.max(answer, kill(map, i, j, M, dx1, dy1));
                answer = Math.max(answer, kill(map, i, j, M, dx2, dy2));
            }
        }
         
        return answer;
    }
     
    public static int kill(int[][] map, int r, int c, int M, int[] dx, int[] dy) {
        int N = map.length;
        int sum = map[r][c];
         
        for(int i=0; i<4; i++) {
            int nr = r;
            int nc = c;
            for(int j=1;  j<M; j++) {
                nr += dx[i];
                nc += dy[i];
                 
                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
             
                sum += map[nr][nc];
            }
        }
        return sum;
    }
}
