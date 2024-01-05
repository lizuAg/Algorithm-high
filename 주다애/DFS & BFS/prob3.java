import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int row = maps.length;
        int col = maps[0].length;
        boolean visited[][] = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int curPos[] = queue.poll();
            int curRow = curPos[0];
            int curCol = curPos[1];
            int curLength = curPos[2];
            if (curRow == row - 1 && curCol == col - 1 ){
                answer = curLength;
                return answer;
            }
            for (int[] d : dir) {
                int nr = curRow + d[0];
                int nc = curCol + d[1];
                if (nr >= 0 && nr < row && nc >=0 && nc < col) {
                    if(maps[nr][nc] == 1 && visited[nr][nc] == false) {
                        queue.offer(new int[]{nr, nc, curLength + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        
        }
        return answer;
    }
}
