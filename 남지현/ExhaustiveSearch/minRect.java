import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        int minHeight = sizes[0][0];
        int minWidth = sizes[0][1];
        for (int i = 1; i< sizes.length; i++) {
            int[] size = sizes[i];
            minHeight = Math.max(minHeight, size[0]);
            minWidth = Math.max(minWidth, size[1]);
        }
        return minHeight * minWidth;
    }
}
