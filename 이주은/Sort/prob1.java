import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int round=0; round<commands.length; round++){
            int i=commands[round][0], j=commands[round][1], k=commands[round][2];
            int[] sliced = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(sliced);
            answer[round] = sliced[k-1];
        }
        
        return answer;
    }
}
