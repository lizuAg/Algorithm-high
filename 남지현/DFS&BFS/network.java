import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[computers.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                visited[i] = true;
                stack.push(i);
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && computers[node][j] == 1) {
                            visited[j] = true;
                            stack.push(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
