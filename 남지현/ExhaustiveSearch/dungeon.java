import java.util.*;
class Solution {
    
    int count = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);
        return count;
    }
    private void dfs(int depth,int[][] dungeons, int exp) {
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (!visited[i] && exp >= dungeon[0]) {
                visited[i] = true;
                dfs(depth + 1, dungeons, exp - dungeon[1]);
                visited[i] = false;
            }
        }
        count = Math.max(count, depth);
    }
}
