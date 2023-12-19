import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] set: commands) {
            int[] subArray = Arrays.stream(array).skip(set[0]-1).limit(set[1]-set[0]+1).toArray();
            Arrays.sort(subArray);
            answer.add(subArray[set[2]-1]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
