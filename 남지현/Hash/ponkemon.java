import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int[] nums) {
        int numberOfMine = nums.length/2;
        Map<Integer, Integer> collection = new HashMap<>();
        for (Integer ponkemon : nums)
            collection.put(ponkemon, collection.getOrDefault(ponkemon, 0) + 1);
        int answer = Math.min(collection.keySet().size(), numberOfMine);
        return answer;
    }
}
