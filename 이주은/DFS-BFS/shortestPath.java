//[프로그래머스] 게임 맵 최단 거리(https://school.programmers.co.kr/learn/courses/30/lessons/1844#)

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    int[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        
        visited = new int[m--][n--];
        
        int[] start = {0, 0};
        
        visited[0][0]++;
        bfs(start, maps);
        
        return visited[m][n]==0 ? -1 : visited[m][n];
    }
    
    public void bfs(int[] start, int[][] maps){
        Deque<int[]> queue = new LinkedList<int[]>();
        queue.add(start);

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0], y = xy[1];
            
            if(x == n && y == m)
                return;
            
            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(nextX >= 0 && nextX <= n && nextY >= 0 && nextY <= m)
                    if(maps[nextY][nextX] == 1 && visited[nextY][nextX] == 0){
                        int[] array = {nextX, nextY};
                        queue.add(array);
                        visited[nextY][nextX] = visited[y][x]+1;
                    }
            }
        }
    }
}
