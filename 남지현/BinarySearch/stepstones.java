import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);
        while (left <= right) {
            int mid = (left+right)/2;
            int startPoint = 0;
            List<Integer> deletedIdx = new ArrayList<>();
            for (int i=0; i<rocks.length; i++) {
                if (rocks[i]-startPoint < mid) {
                    deletedIdx.add(i);
                } else {
                    startPoint = rocks[i];
                }
            }
            int idx = rocks.length-1;
            while (idx >= 0 && distance-rocks[idx] < mid) {
                if (!deletedIdx.contains(idx)) {
                    deletedIdx.add(idx);
                }
                idx--;
            }
            if (deletedIdx.size() > n) {
                right = mid-1;
            } else {
                left = mid+1;
                answer = mid;
            }
        }
        return answer;
    }
}
