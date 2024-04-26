import java.util.*;
import java.io.*;

// Two Dots - 유니온파인드를 이용한 풀이

public class Main {
    static Map<Point, Point> parent;
    static Map<Point, Set<Point>> visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    private static String solution(int N, int M, String[][] board) {
        parent = new HashMap<>();
        visited = new HashMap<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                Point point = new Point(i, j, board[i][j]);
                parent.put(point, point);
                visited.put(point, new HashSet<>());
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                Point now = new Point(i, j, board[i][j]);
                for (int k=0; k<4; k++) {
                    if (i+dx[k]>=0 && i+dx[k]<N && j+dy[k]>=0 && j+dy[k]<M) {
                        Point tmp = new Point(i+dx[k], j+dy[k], board[i+dx[k]][j+dy[k]]);
                        if (now.color.equals(tmp.color) && !visited(visited, now, tmp)) {
                            visited.get(now).add(tmp);
                            visited.get(tmp).add(now);
                            if (hasCycle(now, tmp))
                                return "Yes";
                        }
                    }
                }
            }
        }
        return "No";
    }

    private static boolean visited(Map<Point, Set<Point>> visited, Point p1, Point p2) {
        if (visited.get(p1).contains(p2))
            return true;
        return false;
    }

    private static boolean hasCycle(Point p1, Point p2) {
        p1 = findParent(p1);
        p2 = findParent(p2);
        if (p1.equals(p2))
            return true;
        parent.put(p2, p1);
        return false;
    }

    private static Point findParent(Point p) {
        if (parent.get(p).equals(p))
            return p;
        Point parentNode = findParent(parent.get(p));
        parent.put(p, parentNode);
        return parentNode;
    }
    
    static class Point {
        int x;
        int y;
        String color;
          
        Point (int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public boolean equals(Object o) {
            if (this==o) return true;
            if (this.getClass()!=o.getClass()) return false;
            Point p = (Point) o;
            return this.x==p.x && this.y==p.y;
        }
        
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] board = new String[N][M];
        for (int i=0; i<N; i++) {
            board[i] = bf.readLine().split("");
        }
        System.out.println(solution(N, M, board));
    }
}
