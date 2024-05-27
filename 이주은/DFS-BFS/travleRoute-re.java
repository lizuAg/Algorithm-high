import java.util.*;

class Solution {
    int N;
    String[][] Tickets;
    boolean[] visited;
    Deque<String> path = new ArrayDeque<>();
    
    public String[] solution(String[][] tickets) {
        Tickets = tickets;
        N = tickets.length;
        visited = new boolean[N];
        Arrays.sort(tickets, (a1, a2) -> a1[0].equals(a2[0]) 
                    ? a1[1].compareTo(a2[1]) : a1[0].compareTo(a2[0]));
        
        path.addLast("ICN");
        for(int i=0; i<N; i++) {
            if(tickets[i][0].equals("ICN")) {
                visited[i] = true;
                path.addLast(tickets[i][1]);
                if(dfs(i, 1)) {
                    break;
                }
                path.removeLast();
                visited[i] = false; 
            }
        }
        
        String[] answer = new String[N+1];
        for(int i=0; i<=N; i++) {
            answer[i] = path.removeFirst();
        }
        return answer;
    }
    
    boolean dfs(int idx, int depth) {
        if(depth == N) {
            return true;
        }

        
        for(int i=0; i<N; i++) {
            if(!visited[i] && Tickets[i][0].equals(Tickets[idx][1])) {
                visited[i] = true;
                path.addLast(Tickets[i][1]);
                if(dfs(i, depth+1))
                    return true;
                path.removeLast();
                visited[i] = false;
            }
        }
        return false;
    }
}
