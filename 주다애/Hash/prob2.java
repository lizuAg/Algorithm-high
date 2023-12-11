import java.util.HashMap;

class Hash2 {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size()  >= size) {
            answer = size;
            return answer;
        }
        answer = map.size();
        return answer;
    }
}
