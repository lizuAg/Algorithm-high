import java.util.*;
class Solution {
    List<Set<Integer>> dp;
    public int solution(int N, int number) {
        if (N == number)
            return 1;
        dp = new ArrayList<>();
        for (int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);
        for (int i=2; i<=8; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j=0; j<i; j++) {
                builder.append(N);
            }
            dp.get(i).add(Integer.parseInt(builder.toString()));
            for (int j=1; j<i; j++) {
                for (int val1: dp.get(j)) {
                    for (int val2: dp.get(i-j)) {
                        dp.get(i).add(val1+val2);
                        dp.get(i).add(val1-val2);
                        dp.get(i).add(val1*val2);
                        if (val2 != 0)
                            dp.get(i).add(val1/val2);
                    }
                }
            }
            if (dp.get(i).contains(number))
                return i;
        }
        return -1;
    }
}
