//SWEA 4193 수영대회 결승전

import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        bw.flush();
	}
    
    static int solve() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
            	map[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        String[] line = br.readLine().split(" ");
        int sr = Integer.parseInt(line[0]);
        int sc = Integer.parseInt(line[1]);
        
        line = br.readLine().split(" ");
        int er = Integer.parseInt(line[0]);
        int ec = Integer.parseInt(line[1]);
        
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        visited[sr][sc] = true;
        queue.add(new int[] {sr, sc, 1});
        
        while(!queue.isEmpty()) {
        	int[] curr = queue.poll(); //r, c, s(경과시간: 초)
           
            if(curr[0] == er && curr[1] == ec)
                return curr[2]-1;
            
            for(int i=0; i<4; i++) {
            	int nr = curr[0] + dx[i];
                int nc = curr[1] +dy[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;
                if(map[nr][nc] == 1 || visited[nr][nc])
                    continue;
                else if(map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                	queue.add(new int[] {nr, nc, curr[2]+1});
                }
                else if((curr[2]%3) == 0) { //토네이도가 멈추는 시간이면
                	visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, curr[2]+1});
                } else {
                    queue.add(new int[] {curr[0], curr[1], curr[2]+1});
                }
            }
        }//while-end
        return -1;
    }
}
