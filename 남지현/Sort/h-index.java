import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> integers = new ArrayList<>();
        Arrays.stream(citations).forEach(integers::add);
        integers.sort(Comparator.reverseOrder());
        int count = 0;
        for (int paper: integers) {
            count++;
            if (paper < count){
                return count-1;
            }
        }
        return integers.size();
    }
}
