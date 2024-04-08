import java.util.*;

// 최소성 판단 어떻게 하나?
class Solution {
    static int row;
    static int col;
    static Set<String> set; // 중복 검사를 위해 Set으로 변경
    static List<Set<Integer>> cand;
    static int[] arr;
    static boolean[] used;
    public int solution(String[][] relation) {
        // 데이터 집합 개수
        row = relation.length;
        // 속성 개수(조합 생성)
        col = relation[0].length;
        set = new HashSet<>();
        cand = new ArrayList<>();
        arr = new int[col + 1];
        used = new boolean[col + 1];
        for(int i = 1; i <= col; i++) {
            run(0, i, relation);
            arr = new int[col + 1];
            used = new boolean[col + 1];
        }
        return cand.size();
    }
    
    static void run(int level, int end, String[][] relation) {
        if(level == end) {
            set.clear();
            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < end; j++) {
                    sb.append(relation[i][arr[j]]);
                }
                if (!set.add(sb.toString())) return; // 유일성 검사 실패
            }
            // 유일성 검사 통과
            Set<Integer> newKeySet = new HashSet<>();
            for (int i = 0; i < end; i++) {
                newKeySet.add(arr[i]);
            }
            // 최소성 검사
            // 이미 찾은 후보키가 새로운 조합에 포함되어있으면 -> 후보키 아님
            for(Set<Integer> s : cand) {
                if(newKeySet.containsAll(s)) return;
            }
            // 최소성 검사 통과해야 후보키에 저장됨
            cand.add(newKeySet);
            return;
        }
        
        for(int i = 0; i < col; i++) {
            // 중복X
            if(used[i]) continue;
            // 오름차순
            if(level >= 1 && i < arr[level - 1]) continue;
            arr[level] = i;
            used[i] = true;
            run(level + 1, end, relation);
            arr[level] = 0;
            used[i] = false;
        }
    }
}
