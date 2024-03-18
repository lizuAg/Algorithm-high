// 프로그래머스 - 크레인 인형뽑기 게임
import java.util.*;

class Solution {
    static Stack<Integer> res = new Stack<>();
    static int answer;
    public int solution(int[][] board, int[] moves) {
        int depth = board.length;
        int len = moves.length;
        for(int i = 0; i < len; i++)  {
            int m = moves[i] - 1;
            for(int j = 0; j < depth; j++) {
                if(board[j][m] != 0) {
                    res.push(board[j][m]);
                    if(res.size() >= 2) {
                        peekDoll();
                    }
                    board[j][m] = 0;
                    break;
                }
            }
        }
        return answer * 2;
    }
    
    private void peekDoll() {
        int size = res.size();
        if(res.get(size - 1) == res.get(size - 2)) {
            answer++;
            res.pop();
            res.pop();
        }
    }
}
