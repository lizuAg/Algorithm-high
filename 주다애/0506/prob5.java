import java.util.*;

// union find
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        // 비용이 작은 것부터 우선순위 큐에 저장
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int[] c : costs) {
            pq.offer(new Node(c[0], c[1], c[2]));
        }
        // 배열 초기 세팅. 자기 자신 부모 = 자기 자신
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            // 부모가 다르면 -> 다른 그룹에 속하면
            if(findParent(node.start) != findParent(node.end)) {
                union(node.start, node.end);
                answer += node.cost;
            }
        }
        return answer;
    }
    
    static int findParent(int i) {
        if(parent[i] == i) {
            return i;
        }
        return findParent(parent[i]); // 배열 값을 통해 부모를 다시 찾기
    }
    
    static void union(int a, int b) {
        // 각각 노드의 부모 찾기
        a = findParent(a);
        b = findParent(b);
        // 부모 세팅
        if(a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
    
    class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;
        
        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
