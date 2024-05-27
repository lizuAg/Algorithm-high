import java.util.*;
import java.io.*;

// 테트리스

class Main {

    static int N;
    static List<boolean[][]> tetris;

    private static void initTetris() {
        tetris = new ArrayList<>();
        tetris.add(new boolean[][]{{true}, {true}, {true}, {true}});
        tetris.add(new boolean[][]{{true, true, true, true}});
        tetris.add(new boolean[][]{{true, true, false}, {false, true, true}});
        tetris.add(new boolean[][]{{false, true}, {true, true}, {true, false}});
        tetris.add(new boolean[][]{{true, true, true}, {false, false, true}});
        tetris.add(new boolean[][]{{false, true}, {false, true}, {true, true}});
        tetris.add(new boolean[][]{{true, false, false}, {true, true, true}});
        tetris.add(new boolean[][]{{true, true}, {true, false}, {true, false}});
        tetris.add(new boolean[][]{{false, true, false}, {true, true, true}});
        tetris.add(new boolean[][]{{true, false}, {true, true}, {true, false}});
        tetris.add(new boolean[][]{{true, true, true}, {false, true, false}});
        tetris.add(new boolean[][]{{false, true}, {true, true}, {false, true}});
        tetris.add(new boolean[][]{{true, true}, {true, true}});
    }

    private static int solution(int[][] board) {
        int max=Integer.MIN_VALUE;
        for (boolean[][] piece: tetris) {
            int row = piece.length;
            int col = piece[0].length;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (i+row<=N && j+col<=N) {  // 한 조각의 제일 좌측 상단 점이 (i, j)일 때, 조각의 모든 칸들이 board의 범위 내에 존재하면
                        int sum=0;
                        for (int x=0; x<row; x++) {
                            for (int y=0; y<col; y++) {
                                if(piece[x][y]) sum += board[i+x][j+y];
                            }
                        }
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws Exception {
        int test_case = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        initTetris();
        while ((N = Integer.parseInt(bf.readLine().trim())) > 0) {
            test_case++;
            int[][] board = new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            builder.append(test_case).append(". ").append(solution(board)).append("\n");
        }
        System.out.print(builder);
        bf.close();
    }
}
