//[프로그래머스] 가장 먼 노드(https://school.programmers.co.kr/learn/courses/30/lessons/49189)

import java.util.*;

class Solution {
    List<List<int[]>> graph = new ArrayList<>();
    int answer = 0;
    int max = 0;
    public int solution(int n, int[][] edge) {

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<int[]>());
        }
        
        for(int[] e: edge) {
            graph.get(e[0]).add(new int[] {e[1], 1});
            graph.get(e[1]).add(new int[] {e[0], 1});
        }
        
        int[] result = dijkstra(1, edge.length);

        return answer;
    }
    
    int[] dijkstra(int start, int n) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        cost[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2)-> arr1[1] - arr2[1]);
        pq.add(new int[] {start, 0});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            for(int[] next: graph.get(curr[0])) {
                if(curr[1] + next[1] < cost[next[0]]) {
                    cost[next[0]] = curr[1] + next[1];
                    pq.add(new int[] {next[0], cost[next[0]]});
                    
                    if(max == cost[next[0]])
                        answer++;
                    else if(max < cost[next[0]]) {
                        answer = 1;
                        max = cost[next[0]];
                    }

                }
            }
        }
        
        return cost;
    }
}
