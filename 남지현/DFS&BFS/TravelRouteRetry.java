import java.util.*;

class Solution {
    boolean[] visited;
    String[] answer;
    boolean done;
    int N;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        done = false;
        PriorityQueue<Ticket> pq = new PriorityQueue<Ticket>();
        for (int i=0; i<N; i++) {
            if (tickets[i][0].equals("ICN") && !visited[i]) {
                pq.add(new Ticket(i, tickets[i][0], tickets[i][1]));
            }
        }
        while(!pq.isEmpty()) {
            Ticket now = pq.poll();
            List<Ticket> sequences = new ArrayList<Ticket>();
            sequences.add(now);
            visited[now.idx] = true;
            dfs(1, now, tickets, sequences);
            visited[now.idx] = false;
        }
        return answer;
    }
    
    private void dfs(int depth, Ticket ticket, String[][] tickets, List<Ticket> sequences) {
        if (depth == N) {
            answer = new String[N+1];
            answer[0] = "ICN";
            for (int i=0; i<N; i++) {
                answer[i+1] = sequences.get(i).dst;
            }
            done = true;
            return;
        }
        PriorityQueue<Ticket> cands = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            if (tickets[i][0].equals(ticket.dst) && !visited[i]) {
                cands.add(new Ticket(i, tickets[i][0], tickets[i][1]));
            }
        }
        while(!cands.isEmpty()) {
            Ticket now = cands.poll();
            List<Ticket> tmp = new ArrayList<Ticket>(sequences);
            tmp.add(now);
            visited[now.idx] = true;
            dfs(depth+1, now, tickets, tmp);
            if (done) return; // 경로를 찾는 순간 바로 종료
            visited[now.idx] = false;
        }
    }
    
    static class Ticket implements Comparable<Ticket> {
        int idx;
        String dep;
        String dst;
        
        Ticket(int idx, String dep, String dst) {
            this.idx = idx;
            this.dep = dep;
            this.dst = dst;
        }
        
        public int compareTo(Ticket ticket) {
            return this.dst.compareTo(ticket.dst);
        }
    }
}
