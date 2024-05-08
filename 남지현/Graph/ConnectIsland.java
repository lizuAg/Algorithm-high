import java.util.*;
class Solution {
    
    int[] parent;
   
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i=0; i<n; i++){ 
            parent[i] = i;
        }
        Arrays.sort(costs, (arr1, arr2) -> arr1[2]-arr2[2]);
        for (int[] cost: costs) {
            if(connect(cost[0], cost[1])) {
                answer += cost[2];
            }
        }
        return answer;
    } 
    
    private int findParent(int node) {
        if (parent[node] == node)
            return node;
        return parent[node] = findParent(parent[node]);
    }
    
    private boolean connect(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if (pa != pb) {
            parent[pb] = pa;
            return true;
        }
        return false;
    }
}
