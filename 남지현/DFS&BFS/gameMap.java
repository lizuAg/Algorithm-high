import java.util.*;
class Solution {
    
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row;
    int col;
    
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(1, 0, 0));
        while(!queue.isEmpty()) {
            Block node = queue.poll();
            if (node.x == row-1 && node.y == col-1)
                return node.depth;
            for (int[] direction: move) {
                int newX = node.x + direction[0];
                int newY = node.y + direction[1];
                if (canMoveTo(newX, newY, maps)) {
                    maps[newX][newY] = 0;
                    queue.add(new Block(node.depth+1, newX, newY));
                }
            }
        }
        return -1;
    }
    
    private boolean canMoveTo(int x, int y, int[][] maps) {
        return x >= 0 && x < row && y >= 0 && y < col && maps[x][y] == 1;
    }
    
    static class Block {
        int depth;
        int x;
        int y;

        Block(int depth, int x, int y) {
            this.depth = depth;
            this.x = x;
            this.y = y;
        }
    }
}
