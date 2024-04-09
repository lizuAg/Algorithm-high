import java.util.*;
class Solution {
    static String[][] rows;
    static List<Set<Integer>> candidates = new ArrayList<>();
    public int solution(String[][] relation) {
        rows = relation;
        Set<Integer> full = new HashSet<>();
        for (int i=0; i<rows[0].length; i++) {
            full.add(i);
        }
        for (int i=0; i<rows[0].length; i++) {
            Set<Integer> sub = new HashSet<>(full);
            sub.remove(i);
            dfs(full, sub);
        }
        Collections.sort(candidates, (set1, set2)->set1.size()-set2.size());
        Set<Set<Integer>> removed = new HashSet<>();
        for (int i=0; i<candidates.size(); i++) {
            for (int j=i+1; j<candidates.size(); j++) {
                if (candidates.get(j).containsAll(candidates.get(i))) {
                    removed.add(candidates.get(j));
                }
            }
        }
        for (Set<Integer> set: removed) {
            candidates.remove(set);
        }
        return candidates.size();
    }
    
    private void dfs(Set<Integer> prev, Set<Integer> attributes) {
        if (checkIdentificated(attributes)) {
            if (attributes.size()==1 && !candidates.contains(attributes)) {
                candidates.add(attributes);
            }
            for (Integer idx: attributes) {
                Set<Integer> next = new HashSet<>(attributes);
                next.remove(idx);
                if (next.size() > 0) {
                    dfs(attributes, next);
                }
            }
        } else if (!candidates.contains(prev)) {
            candidates.add(prev);
        }
    }
    
    private boolean checkIdentificated(Set<Integer> attributes) {
        Set<String> set = new HashSet<>();
        for (String[] student: rows) {
            StringBuilder str = new StringBuilder();
            for (int idx: attributes) {
                str.append(student[idx]).append(",");
            }
            set.add(str.toString());
        }
        return set.size()==rows.length;
    }
}
