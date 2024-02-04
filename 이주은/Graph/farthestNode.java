//[프로그래머스] 가장 먼 노드(https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java)

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, max = 0;
        int[] costs = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] != arr2[1] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        for (int i = 2; i <= n; i++)
            costs[i] = Integer.MAX_VALUE;

        //[#node, cost]
        int[] start = {1, 0};
        pq.add(start);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visited[curr[0]])
                continue;

            for (int[] vertex : edge) {
                int[] to = new int[2];
                if (!visited[vertex[1]] && vertex[0] == curr[0]) {
                    to[0] = vertex[1];
                } else if (!visited[vertex[0]] && vertex[1] == curr[0]) {
                    to[0] = vertex[0];
                } else
                    continue;

                to[1] = curr[1] + 1;
                if (to[1] < costs[to[0]]) {
                    costs[to[0]] = to[1];
                    pq.add(to);
                    
                    if (to[1] == max) {
                        answer++;
                    } else if (to[1] > max) {
                        answer = 1;
                        max = to[1];
                    }
                }
            }
            visited[curr[0]] = true;
        }
        return answer;
    }
}

