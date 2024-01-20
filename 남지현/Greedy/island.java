import java.util.*;
class Solution {
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        int cost = 0;
        parents = new int[n];
        for (int i=0; i<n; i++) {
            parents[i] = i;
        }
        Arrays.sort(costs, (arr1, arr2) -> arr1[2]==arr2[2]? arr1[0]-arr2[0]: arr1[2]-arr2[2]);
        for (int[] branch: costs) {
            if (parents[branch[0]] != parents[branch[1]]) {
                int parent = Math.min(parents[branch[0]], parents[branch[1]]);
                int child = Math.max(parents[branch[0]], parents[branch[1]]);
                for (int i=0; i<n; i++) {
                    if (parents[i] == child) {
                        parents[i] = parent;
                    }
                }
                cost += branch[2];
            }
        }
        return cost;
    }
}
