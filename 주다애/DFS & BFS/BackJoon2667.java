package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지 번호 붙이기
public class BaekJoon2667 {
    static int count = 0;
    static int danzi;
    static List<Integer> house = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        danzi = Integer.parseInt(st.nextToken());
        map = new int[danzi][danzi];
        visited = new boolean[danzi][danzi];
        // 입력
        for(int i = 0; i < danzi; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for(int j = 0; j < danzi; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        // 탐색
        for(int i = 0; i < danzi; i++) {
            for(int j = 0; j < danzi; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int a = bfs(i, j);
                    house.add(a);
                    count++;
                }
            }
        }
        Collections.sort(house);
        System.out.println(count);
        for(int h : house) {
            System.out.println(h);
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int answer = 1;
        while(!queue.isEmpty()) {
            int[] target = queue.poll();
            int cx = target[0];
            int cy = target[1];
            for(int[] d : dir) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if(nx >= 0 && nx < danzi && ny >= 0 && ny < danzi) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, answer + 1});
                        visited[nx][ny] = true;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
