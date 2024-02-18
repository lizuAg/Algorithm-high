import java.util.*;

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] win;
    static int[] lose;
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 내가 이긴 노드
        win = new int[n + 1];
        // 내가 진 노드
        lose = new int[n + 1];
        // 인접 리스트
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        // 유향 그래프
        for(int[] result : results) {
            list.get(result[0]).add(result[1]);
        }
        
        for(int i = 1; i <= n; i++) {
            bfs(i, n);
        }
        
        for(int i = 1; i <= n; i++) {            
            int w = win[i];
            int l = lose[i];
            // 내가 이긴 노드 + 내가 진 노드 + 나 == N
            if(w + l + 1 == n) {
                answer++;
            }
        }
        
        return answer; 
    }
    
    void bfs(int x, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.offer(x);
        while(!q.isEmpty()) {
            int t = q.poll();
            for(int v : list.get(t)) {
                if(!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                    lose[v] += 1;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                cnt++;
            }
        }
        // visited[x] == true(현재 기준으로 하는 노드를 bfs while문 전에 visited = true로 해주었으므로)
        // 기준 노드 하나는 빼주어서 계산
        win[x] += cnt - 1;
    }
}
