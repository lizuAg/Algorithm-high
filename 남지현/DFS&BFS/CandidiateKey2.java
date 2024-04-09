import java.util.*;
class Solution {
    String[][] data;
    List<String> candidates = new ArrayList<>();
    
    public int solution(String[][] relation) {
        data = relation;
        for (int i=0; i<data[0].length; i++) {
            boolean[] visited = new boolean[data[0].length];
            dfs(visited, 0, 0, i+1);
        }
        return candidates.size();
    }
    
    private void dfs(boolean[] visited, int start, int depth, int end) {
        if (depth == end) {
            String key = "";
            List<Integer> indexes = new ArrayList<>();
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    indexes.add(i);
                }
            }
            
            Map<String, Integer> map = new HashMap<>();
            
            for (int i=0; i<data.length; i++) {
                String st = "";
                for (Integer idx: indexes) {
                    st += data[i][idx]+",";
                }
                if (map.containsKey(st)) {
                    return;
                } else {
                    map.put(st, 0);
                }
            }
            
            for (String s: candidates) {
                int count=0;
                for (int i=0; i<key.length(); i++) {
                    String sub = String.valueOf(key.charAt(i));
                    if (s.contains(sub)) 
                        count++;
                }
                if (s.length() == count)
                    return;
            }
            candidates.add(key);
        }
        
        for (int i=start; i<visited.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(visited, i, depth+1, end);
            visited[i] = false;
        }
    }
}
