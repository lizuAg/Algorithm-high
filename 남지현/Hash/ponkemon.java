import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int numberOfMine = nums.length/2;
        Map<Integer, Integer> collection = new HashMap<>();
        for (int ponkemon: nums) {
            if (collection.containsKey(ponkemon))
                collection.put(ponkemon, collection.get(ponkemon)+1);
            else
                collection.put(ponkemon, 1);
        }
        int numberOfTypes = collection.keySet().size();
        answer = Math.min(numberOfTypes, numberOfMine);
        return answer;
    }
}
