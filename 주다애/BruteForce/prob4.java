import java.util.*;

// 근의 공식 약 5년만에 써봤습니다..
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        int b = 2 - (brown / 2);
        int c = 4 * yellow;
        int x = (-b + (int)Math.sqrt(b*b - c)) / 2;
        int y = (-b - (int)Math.sqrt(b*b - c)) / 2;
        if(x == y) {
            answer[0] = x + 2;
            answer[1] = x + 2;
        }
        else {
            answer[0] = x + 2;
            answer[1] = y + 2;
        }
        return answer;
    }
}
