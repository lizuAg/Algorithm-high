//[프로그래머스] 여행경로 (https://school.programmers.co.kr/learn/courses/30/lessons/43164?itm_content=course14743#)

import java.util.*;

class Solution {
    ArrayList<String[]> list = new ArrayList<>();
    Deque<String> deque = new ArrayDeque<>();
        
    int len;
    boolean[] visited;
    
    public void dfs(String[] now){
        if(deque.size() == len)
            return;
        
        //방문하지 않았으면서, 알파벳 순서가 앞서는 다음 공항을 찾기
        for(int i=0; i<len; i++){
            String[] next = list.get(i);
            if(!visited[i] && now[1].equals(next[0])){
                visited[i] = true;
                deque.add(next[1]);
                
                dfs(next);
                
                if(deque.size() == len)
                    return;
                visited[i] = false;
                deque.pollLast();
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        visited = new boolean[len];
        String[] answer = new String[len+1];
        
        for(String[] ticket : tickets)
            list.add(ticket);
        list.sort(new TicketComparator());
        
        
        for(int i=0; i<len; i++){
            String[] ticket = list.get(i);
            if(ticket[0].equals("ICN")){
                visited[i] = true;
                deque.add(ticket[1]);
                dfs(ticket);
                
                if(deque.size() == len)
                    break;
                
                visited[i] = false;
                deque.pollLast();
            }
        }
        
        answer[0] = "ICN";
        for(int i=1; i<len+1; i++){
            answer[i] = deque.poll();
        }
        return answer;
    }
}

class TicketComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] a, String[] b) {
        return a[1].compareTo(b[1]);
    }
}
