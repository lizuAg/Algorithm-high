import java.util.*;
public class Solution {
    boolean[] visited;
    ArrayList<Ticket> entireTickets = new ArrayList<>();
    ArrayList<Ticket> route;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        ArrayList<Ticket> dep = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            Ticket ticket = new Ticket(i, tickets[i][0], tickets[i][1]);
            entireTickets.add(ticket);
            if (ticket.departure.equals("ICN")) {
                dep.add(ticket);
            }
        }
        Collections.sort(dep);
        for (Ticket ticket: dep) {
        	ArrayList<Ticket> tmp = new ArrayList<>();
        	tmp.add(ticket);
        	visited[ticket.idx] = true;
            dfs(tmp);
            visited[ticket.idx] = false;
        }
        return getAirports();
    }
    
    private boolean visitCompleted() {
        for (boolean flag: visited) {
            if (!flag)
                return false;
        }
        return true;
    }
    
    private void dfs(ArrayList<Ticket> status) {
        if (visitCompleted()){
        	route = (ArrayList<Ticket>) status.clone();
            return;
        }
        Ticket now = status.get(status.size()-1);
        ArrayList<Ticket> dep = new ArrayList<>();
        for (Ticket ticket: entireTickets) {
            if (now.isConnectedTo(ticket) && !visited[ticket.idx]) {
                dep.add(ticket);
            }
        }
        Collections.sort(dep);
        for (Ticket next: dep) {
            ArrayList<Ticket> copy = (ArrayList<Ticket>) status.clone();
            copy.add(next);
            visited[next.idx] = true;
            dfs(copy);
            visited[next.idx] = false;
        }
    }
    
    private String[] getAirports() {
        String[] airports = new String[route.size()+1];
        airports[0] = "ICN";
        for (int i = 1; i < route.size()+1; i++) {
            airports[i] = route.get(i-1).arrival;
        }
        return airports;
    }
    
    static class Ticket implements Comparable<Ticket>{
        private int idx;
        private String departure;
        private String arrival;
        
        Ticket(int idx, String departure, String arrival) {
            this.idx = idx;
            this.departure = departure;
            this.arrival = arrival;
        }
        
        public int compareTo(Ticket object) {
            int arrivals = object.arrival.compareTo(this.arrival);
            if (arrivals == 0)
            	return object.departure.compareTo(this.departure);
            return arrivals;
        }
        
        public boolean isConnectedTo(Ticket object) {
            return this.arrival.equals(object.departure);
        }
    }
}
