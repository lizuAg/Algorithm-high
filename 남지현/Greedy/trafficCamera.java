import java.util.*;
class Solution {
    Stack<int[]> counts = new Stack<>();
    public int solution(int[][] routes) {
        Arrays.sort(routes, (arr1, arr2) -> arr1[0]==arr2[0]? arr1[1]-arr2[1]: arr1[0]-arr2[0]);
        int idx = 1;
        int n = routes.length;
        counts.push(routes[0]);
        while (idx < n) {
            int[] now = counts.pop();
            int[] part = overlapped(now, routes[idx]);
            if (part[0] <= part[1]) {
                counts.push(part);
            } else {
                counts.push(now);
                counts.push(routes[idx]);
            }
            idx++;
        }
        return counts.size();
    }
    private int[] overlapped(int[] before, int[] after) {
        return new int[]{Math.max(before[0], after[0]), Math.min(before[1], after[1])};
    }
}
