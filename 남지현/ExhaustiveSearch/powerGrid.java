import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer> numbers = new ArrayList<>();
        for (int cutIdx = 0; cutIdx < wires.length; cutIdx++) {
            Map<Integer, List<Integer>> tree = new HashMap<>();
            for (int i = 0; i < n; i++) {
                tree.put(i+1, new ArrayList<>());
            }
            for (int i = 0; i < wires.length; i++) {
                int[] edge = wires[i];
                if (i != cutIdx){
                    tree.get(edge[0]).add(edge[1]);
                    tree.get(edge[1]).add(edge[0]);
                }
            }
            int[] visited = new int[n];
            List<Integer> numberOfNodes = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                int count = 0;
                if (visited[i] == 0) {
                    stack.push(i+1);
                    visited[i] = 1;
                    count++;
                    while(!stack.isEmpty()) {
                        int node = stack.pop();
                        for (int j = 0; j < n; j++) {
                            if (visited[j] == 0 && tree.get(j+1).contains(node)) {
                                stack.push(j+1);
                                visited[j] = 1;
                                count++;
                            }
                        }
                    }
                    numberOfNodes.add(count);
                }
            }
            if (numberOfNodes.size() == 2) {
                numbers.add(Math.abs(numberOfNodes.get(0) - numberOfNodes.get(1)));
            }
        }
        return numbers.stream().mapToInt(Integer::intValue).min().orElse(-1);
    }
}
