// 그래프 - 가장 먼 노드
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
                
        // 결과 저장(노드 : 거리)
        Map<Integer, Integer> map = new HashMap<>();
        
        // 인접 행렬 --> 8,9번 메모리 초과 이슈
        // int[][] matrix = new int[n + 1][n + 1];
        
	// for(int[] e : edge) {
	// 	matrix[e[0]][e[1]] = 1;
	// 	matrix[e[1]][e[0]] = 1;
	// }
        
        // 인접 행렬 풀이
        // while(!q.isEmpty()) {
        //     int[] target = q.poll();
        //     int value = target[0];
        //     int depth = target[1];
        //     for(int i = 0; i < n + 1; i++) {
        //         if(matrix[value][i] == 1 && !visited[i]) {
        //             q.offer(new int[]{i, depth + 1});
        //             visited[i] = true;
        //             map.put(i, depth + 1);
        //         }
        //     }
        // }
        
        // 인접 리스트
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
	    list.get(e[0]).add(e[1]);
	    list.get(e[1]).add(e[0]);
	}

        // BFS 탐색
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()) {
            int[] target = q.poll();
            int value = target[0];
            int depth = target[1];
            for(int v : list.get(value)) {
                if(!visited[v]) {
                    q.offer(new int[]{v, depth + 1});
                    visited[v] = true;
                    map.put(v, depth + 1);
                }
            }
        }
        
        int max = 0;
        for(Integer i : map.keySet()) {
            if(max < map.get(i)) {
                max = map.get(i);
            }
        }
        for(Integer i : map.keySet()) {
            if(map.get(i) == max) {
                answer++;
            }
        }
        return answer;
    }
}
