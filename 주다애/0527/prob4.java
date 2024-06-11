import java.util.*;

class Solution {
    static List<String> ans;
    static String[] path;
    static boolean[] used;
    static int len;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        len = tickets.length;
        ans = new ArrayList<>();
        path = new String[len];
        used = new boolean[len];
        run(0, "ICN", tickets);
        Collections.sort(ans);
        return ans.get(0).split(" ");
    }
    
    static void run(int level, String now, String[][] tickets) {
        if(level == len) {
            String p = "";
            p += "ICN" + " ";
            for(String s : path) {
                p += s + " ";
            }
            ans.add(p);
            return;
        }
        
        for(int i = 0; i < len; i++) {
            if(!used[i] && now.equals(tickets[i][0])) {
                path[level] = tickets[i][1];
                used[i] = true;
                run(level + 1, tickets[i][1], tickets);
                path[level] = "";
                used[i] = false;
            }
        }
    }
}
