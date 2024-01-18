import java.util.*;

class Solution {
    boolean[] visited;
    Queue<Integer> queue;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        queue = new LinkedList<>();
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                network(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void network(int x, int[][] computers) {
        queue.offer(x);
        visited[x] = true;
        
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int i = 0; i < computers[0].length; i++) {
                if (computers[c][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
