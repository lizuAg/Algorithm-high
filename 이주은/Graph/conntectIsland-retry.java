//프로그래머스 섬 연결하기#MST #Union-Find (https://school.programmers.co.kr/learn/courses/30/lessons/42861)

import java.util.*;

class Solution {
    private int[] parent;
    
    public int find(int a) {
        if(parent[a] == a)
            return a;
        else 
            return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        for(int i = 0; i < costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}
