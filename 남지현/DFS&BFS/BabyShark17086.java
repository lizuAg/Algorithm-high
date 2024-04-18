import java.io.*;
import java.util.*;

public class Main {
	
	private static int solution2(int N, int M, int[][] map) {
		int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
		Queue<int[]> queue = new LinkedList<>();
		int[][] dist = new int[N][M];
		int answer = -1;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 1)
					queue.add(new int[] {i, j});
			}
		}
		while (! queue.isEmpty()) {
			int[] node = queue.poll();
			for (int i=0; i<8; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] +dy[i];
				if (nx<0 || nx>=N || ny<0 || ny>=M)
					continue;
				if (dist[nx][ny]!=0 || map[nx][ny]==1)
					continue;
				dist[nx][ny] = dist[node[0]][node[1]]+1;
				answer = Math.max(answer, dist[nx][ny]);
				queue.add(new int[] {nx, ny});
			}
		}
		return answer;
	}
	
	private static int solution(int N, int M, int[][] map) {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
		int max = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int dist = 0;
				boolean[][] visited = new boolean[N][M];
				Queue<int[]> queue = new LinkedList<>();
				if (map[i][j] == 1)
					continue;
				queue.add(new int[] {i, j, 0});
				while (! queue.isEmpty()) {
					int[] now = queue.poll();
					if (map[now[0]][now[1]] == 1) {
						dist = now[2];
						break;
					}
					if (visited[now[0]][now[1]])
						continue;
					visited[now[0]][now[1]] = true;
					for (int[] d: dir) {
						if (now[0]+d[0]>=0 && now[0]+d[0]<N && now[1]+d[1]>=0 && now[1]+d[1]<M) {
							queue.add(new int[] {now[0]+d[0], now[1]+d[1], now[2]+1});
						}
					}
				}
				max = Math.max(max, dist);
			}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] arg = bf.readLine().split(" ");
		int N = Integer.parseInt(arg[0]);
		int M = Integer.parseInt(arg[1]);
		int[][] map = new int[N][M];
		for (int i=0; i<N; i++) {
			arg = bf.readLine().split(" ");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(arg[j]);
			}
		}
		System.out.println(solution(N, M, map));
		System.out.println(solution2(N, M, map));
		bf.close();
	}
}
