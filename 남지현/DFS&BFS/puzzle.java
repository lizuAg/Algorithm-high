import java.util.*;
class Solution {
    int N;
    boolean[] used;
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    List<List<int[]>> pieces = new ArrayList<>();
    List<List<int[]>> blanks = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int count = 0;
        N = game_board.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) { // 하나의 피스
                    List<int[]> piece = new ArrayList<>();
                    table[i][j] = 0;
                    findPiece(i, j, table, piece);
                    pieces.add(piece);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0) { // 하나의 빈칸
                    List<int[]> blank = new ArrayList<>();
                    game_board[i][j] = 1;
                    findBlank(i, j, game_board, blank);
                    blanks.add(blank);
                }
            }
        }
        
        used = new boolean[pieces.size()];
        for (List<int[]> blank: blanks) {
            for (int i = 0; i < pieces.size(); i++) {
                List<int[]> piece = pieces.get(i);
                if (!used[i] && piece.size() == blank.size()) {
                    List<List<int[]>> cases = rotate(piece);
                    List<int[]> block = minimizeValue(blank);
                    for (List<int[]> puzzle: cases) {
                        if (lookTheSame(puzzle, block)) {
                            count += puzzle.size();
                            used[i] = true;
                            break;
                        }
                    }
                    if (used[i])
                        break;
                }
            }
        }
        return count;
    }
    
    boolean lookTheSame(List<int[]> puzzle, List<int[]> blank) {
        int n = puzzle.size();
        puzzle.sort((arr1, arr2) -> arr1[0]==arr2[0]? arr1[1]-arr2[1]: arr1[0]-arr2[0]);
        blank.sort((arr1, arr2) -> arr1[0]==arr2[0]? arr1[1]-arr2[1]: arr1[0]-arr2[0]);
        for (int i = 0; i < n; i++) {
            if (! Arrays.equals(puzzle.get(i), blank.get(i)))
                return false;
        }
        return true;
    }
    
    boolean canMoveTo(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
    
    void findBlank(int x, int y, int[][] board, List<int[]> blank) {
        blank.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int newX = x + move[i][0];
            int newY = y + move[i][1];
            if (canMoveTo(newX, newY) && board[newX][newY]==0) {
                board[newX][newY] = 1;
                findBlank(newX, newY, board, blank);
            }
        }
    }
    
    void findPiece(int x, int y, int[][] table, List<int[]> piece) {
        piece.add(new int[]{x, y});
        for (int i = 0; i < 4; i++) {
            int newX = x + move[i][0];
            int newY = y + move[i][1];
            if (canMoveTo(newX, newY) && table[newX][newY]==1) {
                table[newX][newY] = 0;
                findPiece(newX, newY, table, piece);
            }
        }
    }
    
    List<List<int[]>> rotate(List<int[]> piece) {
        List<List<int[]>> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int[] point: piece) {
                // 회전변환
                int tmp = point[0];
                point[0] = -1 * point[1];
                point[1] = tmp;
            }
            result.add(minimizeValue(piece));
        }
        return result;
    }
    
    List<int[]> minimizeValue(List<int[]> piece) {
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] point: piece) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }
        for (int[] point: piece) {
            result.add(new int[]{point[0] - minX, point[1] - minY});
        }
        return result;
    }
}
