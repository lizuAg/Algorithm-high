import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) map.put(i, 0);
        
        return map.size() < nums.length/2 ? map.size() : nums.length/2;
    }
}