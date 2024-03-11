//[프로그래머스] 크레인 인형뽑기 게임 (https://school.programmers.co.kr/learn/courses/30/lessons/64061#)

import java.util.*;

class Solution {
    ArrayDeque<Integer> stack;
    
    public int solution(int[][] board, int[] moves) {
        stack = new ArrayDeque<>();
        int cnt = 0;

        for(int move : moves) {
            int doll = pickADoll(board, move-1);

            if(doll == 0)
                continue;
            else if(!stack.isEmpty() && stack.peek() == doll){
                stack.pop();

                cnt += 2;
            }
            else {
                stack.push(doll);
            }
        }
        
        return cnt;
    }
    
   int pickADoll (int[][] board, int move) {
        int doll = 0;
        
        for(int i=0; i<board.length; i++){
            doll = board[i][move];
            if(doll != 0){
                board[i][move] = 0;
                break;
            }
        }
       return doll;
    }
}
