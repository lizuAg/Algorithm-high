import java.util.*;

class Solution {
    // 중복 저장할 필요 없음
    static List<Set<Integer>> set = new ArrayList<>();
    public int solution(int N, int number) {
        int answer = 0;
        for (int i = 0; i <= 8; i++) {
            set.add(new HashSet<>());             
        }
        set.get(1).add(N);
        
        // 계산할 필요 없음
        if(N == number) {
            return 1;
        }
        
        String st = Integer.toString(N);
        for(int i = 2; i <= 8; i++) {
            for(int j = 1; j <= i / 2; j++) {
                operations(i, set.get(i - j), set.get(j));
                operations(i, set.get(j), set.get(i - j));
            }
            // 55, 555와 같은 연속되는 숫자 저장
            st += Integer.toString(N);
            set.get(i).add(Integer.valueOf(st));  
            
            if(set.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
    
    static void operations(int i, Set<Integer> first, Set<Integer> second) {
        for(int a : first) {
            for(int b : second) {
                set.get(i).add(a + b);
                set.get(i).add(a - b);
                set.get(i).add(a * b);
                if(b != 0) {
                    set.get(i).add(a / b);
                }
            }
        }
    }
}
