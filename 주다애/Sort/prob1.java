import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = array.length;
        int cLen = commands.length;
        
        int[] answer = new int[cLen];
        for(int i = 0; i < cLen; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
