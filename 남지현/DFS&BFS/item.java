import java.util.*;
class Solution {
    int[][] map = new int[102][102];
    int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int count;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect: rectangle) {
            for (int i = 2*rect[1]; i <= 2*rect[3]; i++) {
                for (int j = 2*rect[0]; j <= 2*rect[2]; j++) {
                    map[i][j] = 1;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        bfs(new int[]{2*characterX, 2*characterY}, new int[]{2*itemX, 2*itemY}, queue);
        
        return count/2;
    }
    
    void bfs(int[] dep, int[] arrival, Queue<int[]> queue) {
        queue.add(new int[]{0, dep[1], dep[0]});
        while (! queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[1] == arrival[1] && node[2] == arrival[0]) {
                count = node[0];
                return;
            }
            for (int i = 0; i < 4; i++) {
                int newX = node[1] + move[i][0];
                int newY = node[2] + move[i][1];
                if (canMoveTo(newX, newY)) {
                    map[newX][newY] = 2;
                    queue.add(new int[]{node[0]+1, newX, newY});
                }
            }
        }
    }
    
    boolean canMoveTo(int x, int y) {
        if (x>1 && x<102 && y>1 && y<102 && map[x][y]==1){
            for (int[] dir: direction) {
                if (map[x+dir[0]][y+dir[1]]==0)
                    return true;
            }
        }
        return false;
    }
}
