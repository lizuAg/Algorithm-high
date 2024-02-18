//[프로그래머스] 가장 먼 노드(https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=java)

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int max = 0, answer = 0;
        int[] costs = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int[] e : edge){
                int next;
                if(!visited[e[1]] && curr == e[0]){
                    next = e[1];
                }
                else if(!visited[e[0]] && curr == e[1]){
                    next = e[0];
                }
                else
                    continue;
                
                costs[next] = costs[curr] + 1;
                visited[next] = true;
                queue.add(next);
                
                if(costs[next] > max){
                    max = costs[next];
                    answer = 1;
                }else if(costs[next] == max){
                    answer ++;
                }

            }
        }
        return answer;
    }
}

