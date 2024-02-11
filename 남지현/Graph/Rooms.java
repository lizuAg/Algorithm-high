import java.util.*;
class Solution {
    int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    Map<Point, List<Point>> graph = new HashMap<>();
    
    public int solution(int[] arrows) {
        int answer = 0;
        Point now = new Point(0, 0);
        for (int arrow: arrows) {
            for (int i=0; i<2; i++) { // scale-up
                Point next = new Point(now.x+dir[arrow][0], now.y+dir[arrow][1]);
                if (!graph.containsKey(next)) {
                    graph.put(next, makeListContainsPoint(now));
                    if (graph.get(now) == null) {
                        graph.put(now, makeListContainsPoint(next));
                    } else {
                        graph.get(now).add(next);
                    }
                } else if (graph.containsKey(now) && !graph.get(next).contains(now)) {
                    graph.get(next).add(now);
                    graph.get(now).add(next);
                    answer++;
                }
                now = next;
            }
        }
        return answer;
    }
    
    private List<Point> makeListContainsPoint(Point point) {
        return new ArrayList<Point>(List.of(point));
    }
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
        
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return this.x==point.x && this.y==point.y;
        }
    }
}
