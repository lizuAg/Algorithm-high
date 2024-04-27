import java.util.Scanner;

// Two Dots(골드 4)
// 이전 방문 노드를 만남 -> 그게 바로 직전이 아니면 사이클
// 직전 노드를 같이 탐색하는 것이 중요
public class BaekJoon16929 {
    static char[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // cycle 찾기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 매번 visited 배열 업데이트(다시 탐색하므로)
                visited = new boolean[n][m];
                if(dfs(i, j, -1, -1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int r, int c, int lastR, int lastC) {
        int v = map[r][c];
        visited[r][c] = true;
        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            // 움직일 수 있고 + 값이 같으면
            if(canMove(nr, nc) && map[nr][nc] == v) {
                // 방문 안한 정점이면 dfs 다시 실행
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, r, c);
                }
                // 방문했는데, 직전 노드와 다르면 -> 사이클 있음
                else if(lastR != nr || lastC != nc) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canMove(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= m) return false;
        return true;
    }
}
