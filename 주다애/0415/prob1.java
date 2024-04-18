import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer;
	static int map[][];
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상 우 하 좌
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        run(0);
        System.out.println(answer);
    }

	private static void run(int level) {
		// 5번 하면 종료
		// 이 때 최대값 구함
		if(level == 5) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					answer = Math.max(answer, map[i][j]);
				}
			}
			return;
		}
		
		int[][] temp = new int[n][n];
		for(int i = 0; i < n; i++) {
			temp[i] = map[i].clone();
		}
		
		for(int i = 0; i < 4; i++) {
			change(i);
			run(level + 1);
			for(int j = 0; j < n; j++) {
				map[j] = temp[j].clone();
			}
		}
	}

	private static void change(int d) {
		boolean[][] visited = new boolean[n][n];
		switch(d) {
			// 상
			case(0) : {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						int dx = dir[d][0];
						int dy = dir[d][1];
						int nx = i + dx;
						int ny = j + dy;
						if(canMove(nx, ny) && !visited[nx][ny]) {
							if(map[i][j] == 0) continue;
							if(map[nx][ny] == map[i][j]) {
								map[nx][ny] *= 2;
								visited[nx][ny] = true;
								map[i][j] = 0;
							}
							if(map[nx][ny] == 0) {
								map[nx][ny] = map[i][j];
								map[i][j] = 0;
								while(true) {
									int cx = nx;
									int cy= ny;
									nx += dx;
									ny += dy;
									if(canMove(nx, ny) && map[nx][ny] == 0) {
										map[nx][ny] = map[cx][cy];
										map[cx][cy] = 0;
										continue;
									}
									if(canMove(nx, ny) && map[nx][ny] == map[cx][cy] && !visited[nx][ny]) {
										map[nx][ny] *= 2;
										visited[nx][ny] = true;
										map[cx][cy] = 0;
									}
									break;
								}
							}
						}
					}
				}
			}
			break;
			// 우
			case(1) : {
				for(int i = 0; i < n; i++) {
					// 
					for(int j = n - 1; j >= 0; j--) {
						int dx = dir[d][0];
						int dy = dir[d][1];
						int nx = i + dx;
						int ny = j + dy;
						if(canMove(nx, ny) && !visited[nx][ny]) {
							if(map[i][j] == 0) continue;
							if(map[nx][ny] == map[i][j]) {
								map[nx][ny] *= 2;
								visited[nx][ny] = true;
								map[i][j] = 0;
							}
							if(map[nx][ny] == 0) {
								map[nx][ny] = map[i][j];
								map[i][j] = 0;
								while(true) {
									int cx = nx;
									int cy= ny;
									nx += dx;
									ny += dy;
									if(canMove(nx, ny) && map[nx][ny] == 0) {
										map[nx][ny] = map[cx][cy];
										map[cx][cy] = 0;
										continue;
									}
									if(canMove(nx, ny) && map[nx][ny] == map[cx][cy] && !visited[nx][ny]) {
										map[nx][ny] *= 2;
										visited[nx][ny] = true;
										map[cx][cy] = 0;
									}
									break;
								}
							}
						}
					}
				}	
			}
			break;
			// 하
			case(2) : {
				for(int i = n - 1; i >= 0; i--) {
					for(int j = 0; j < n; j++) {
						int dx = dir[d][0];
						int dy = dir[d][1];
						int nx = i + dx;
						int ny = j + dy;
						if(canMove(nx, ny) && !visited[nx][ny]) {
							if(map[i][j] == 0) continue;
							if(map[nx][ny] == map[i][j]) {
								map[nx][ny] *= 2;
								visited[nx][ny] = true;
								map[i][j] = 0;
							}
							if(map[nx][ny] == 0) {
								map[nx][ny] = map[i][j];
								map[i][j] = 0;
								while(true) {
									int cx = nx;
									int cy= ny;
									nx += dx;
									ny += dy;
									if(canMove(nx, ny) && map[nx][ny] == 0) {
										map[nx][ny] = map[cx][cy];
										map[cx][cy] = 0;
										continue;
									}
									if(canMove(nx, ny) && map[nx][ny] == map[cx][cy] && !visited[nx][ny]) {
										map[nx][ny] *= 2;
										visited[nx][ny] = true;
										map[cx][cy] = 0;
									}
									break;
								}
							}
						}
					}
				}
			}
			break;
			// 좌
			case(3) : {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						int dx = dir[d][0];
						int dy = dir[d][1];
						int nx = i + dx;
						int ny = j + dy;
						if(canMove(nx, ny) && !visited[nx][ny]) {
							if(map[i][j] == 0) continue;
							if(map[nx][ny] == map[i][j]) {
								map[nx][ny] *= 2;
								visited[nx][ny] = true;
								map[i][j] = 0;
							}
							if(map[nx][ny] == 0) {
								map[nx][ny] = map[i][j];
								map[i][j] = 0;
								while(true) {
									int cx = nx;
									int cy= ny;
									nx += dx;
									ny += dy;
									if(canMove(nx, ny) && map[nx][ny] == 0) {
										map[nx][ny] = map[cx][cy];
										map[cx][cy] = 0;
										continue;
									}
									if(canMove(nx, ny) && map[nx][ny] == map[cx][cy] && !visited[nx][ny]) {
										map[nx][ny] *= 2;
										visited[nx][ny] = true;
										map[cx][cy] = 0;
									}
									break;
								}
							}
						}
					}
				}
			}
			break;
		}
	}
	
	// 움직일 수 있는지 판단
	private static boolean canMove(int x, int y) {
		if(x < 0 || x >= n || y < 0 || y >= n) return false;
		return true;
	}
}
