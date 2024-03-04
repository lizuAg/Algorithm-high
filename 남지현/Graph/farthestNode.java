import java.util.*;
class Solution {
    Map<Integer, List<Integer>> graph;
    PriorityQueue<int[]> pq;
    int[] shortest;
    public int solution(int n, int[][] edge) {
        pq = new PriorityQueue<>((arr1, arr2) -> arr1[1]-arr2[1]);
        graph = new HashMap<>();
        shortest = new int[n+1];
        for (int i=1; i<n+1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e: edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        for (int i=2; i<n+1; i++) {
            shortest[i] = 50001;
        }
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            for (int dst: graph.get(node[0])) {
                if (node[1]+1 < shortest[dst]) {
                    shortest[dst] = node[1]+1;
                    pq.add(new int[]{dst, node[1]+1});
                }
            }
        }
        int max = 0;
        int count = 0;
        for (int dist: shortest) {
            max = Math.max(max, dist);
        }
        for (int dist: shortest) {
            if (dist==max)
                count++;
        }
        return count;
    }
}
