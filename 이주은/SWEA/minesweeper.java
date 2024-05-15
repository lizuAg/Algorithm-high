import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			bw.write("#"+test_case+" "+solve()+"\n");
		}
        br.close();
        bw.close();
	}
    
    public static int solve() throws IOException {
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        boolean[][] visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split("");
        	for(int j=0; j<N; j++) {
                if(line[j].equals("*"))
                	map[i][j] = true;
            }
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
            	if(!map[i][j] && !visited[i][j] && isZeroCell(i, j, map, N)) {
                	dfs(i, j, map, visited, N);
                    answer++;
                }
            }
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
            	if(!map[i][j] && !visited[i][j] ) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static void dfs(int x, int y, boolean[][] map, boolean[][] visited, int N) {
        visited[x][y] = true;
      	for(int i=0; i<8; i++) {
        	int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]);
            else {
                if(isZeroCell(nextX, nextY, map, N))
                	dfs(nextX, nextY, map, visited, N);
                else
                    visited[nextX][nextY] = true;
                    
            }
        }
    }
    
    static boolean isZeroCell(int x, int y, boolean[][] map, int N) {
    	for(int i=0; i<8; i++) {
        	int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N);
            else if(map[nextX][nextY])
                return false;
        }
        return true;
    }
}
