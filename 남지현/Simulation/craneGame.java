import java.util.*;
class Solution {
    List<Stack<Integer>> machine = new ArrayList<>();
    Stack<Integer> basket = new Stack<>(); 
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        for (int i=0; i<=N; i++) {
            machine.add(new Stack<Integer>());
        }
        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<N; j++) {
                if (board[i][j] > 0)
                    machine.get(j).push(board[i][j]);
            }
        }
        for (int col: moves) {
            if (machine.get(col-1).size()>0) {
                int doll = machine.get(col-1).pop();
                basket.push(doll);
            }
            if (basket.size()>=2) {
                int first = basket.pop();
                int second = basket.pop();
                if (first==second)
                    answer+=2;
                else{
                    basket.push(second);
                    basket.push(first);
                }
            }
        }
        return answer;
    }
}
