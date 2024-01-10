import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    boolean[] used;

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                String[] path = new String[tickets.length + 1];
                used = new boolean[tickets.length];
                path[0] = "ICN";
                used[i] = true;
                path[1] = tickets[i][1];
                dfs(tickets, path, 1);
            }
        }
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public void dfs(String[][] tickets, String[] path, int level) {
        if (level == tickets.length) {
            String strPath = String.join(" ", path);
            list.add(strPath);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(path[level])) {
                used[i] = true;
                path[level + 1] = tickets[i][1];
                dfs(tickets, path, level + 1);
                used[i] = false;
            }
        }
    }
}
