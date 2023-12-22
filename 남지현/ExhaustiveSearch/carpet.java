import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> yellows = getCandidates(yellow);
        List<int[]> sizes = getCandidates(brown+yellow);
        for (int[] center: yellows) {
            for (int[] total: sizes) {
                List<Integer> size = new ArrayList<>(getSize(total, center));
                if (size.get(0)>0) {
                    size.sort(Collections.reverseOrder());
                    return size.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[2];
    }
    private List<Integer> getSize(int[] totalSize, int[] centerSize) {
        if (
            (totalSize[0]> centerSize[0] 
             && totalSize[1]> centerSize[1] 
             && (totalSize[0]-centerSize[0])%2==0 
             && (totalSize[1]-centerSize[1])%2==0)
            || (totalSize[0]> centerSize[1] && 
                totalSize[1] > centerSize[0] 
                && (totalSize[0]-centerSize[1])%2==0 
                && (totalSize[1]-centerSize[0])%2==0)
        )
            return List.of(totalSize[0], totalSize[1]);
        return List.of(-1, -1);
    }
    private List<int[]> getCandidates(int total) {
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(total); i++) {
            if (total%i == 0) {
                int[] candidate = {i, total/i};
                result.add(candidate);
            }
        }
        return result;
    }
}
