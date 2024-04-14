//BOJ 12100번 2048 (Easy) (https://www.acmicpc.net/submit/12100/76960565)

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static int answer;
    public static void main(String[] args) throws IOException {
        input();

        dfs(board, 0);

        System.out.println(answer);
    }

    static void dfs(int[][] board, int depth) {
        if(depth == 5) {
            answer = Math.max(answer, findMax(board));
            return;
        }
        
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[][] right = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=N-1; j>=0; j--) {
                if(board[i][j] == 0)
                    continue;
                else if(dequeue.isEmpty() || board[i][j] != dequeue.peekFirst()) {
                    dequeue.addFirst(board[i][j]);
                    // System.out.printf("add: %d(%d)\n", board[i][j], dequeue.peekFirst());
                }
                else {
                    dequeue.removeFirst();
                    dequeue.addFirst(board[i][j]*2);
                    dequeue.addFirst(0);
                }
            }
            for(int j=N-1; j>=0; j--) {
                if(dequeue.isEmpty())
                    break;
                while(!dequeue.isEmpty()) {
                    int temp =  dequeue.removeLast();
                        if(temp != 0) {
                            right[i][j] = temp;
                            break;
                        }
                }
            }
        }

        int[][] left = new int[N][N];      
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 0)
                    continue;
                else if(dequeue.isEmpty() || board[i][j] != dequeue.peekFirst()) {
                    dequeue.addFirst(board[i][j]);
                }
                else {
                    dequeue.removeFirst();
                    dequeue.addFirst(board[i][j]*2);
                    dequeue.addFirst(0);
                }
            }
            for(int j=0; j<N; j++) {
                if(dequeue.isEmpty())
                    break;
                while(!dequeue.isEmpty()) {
                    int temp =  dequeue.removeLast();
                        if(temp != 0) {
                            left[i][j] = temp;
                            break;
                        }
                }
            }
        }
        int[][] up = new int[N][N];
        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(board[i][j] == 0)
                    continue;
                else if(dequeue.isEmpty() || board[i][j] != dequeue.peekFirst()) {
                    dequeue.addFirst(board[i][j]);
                }
                else {
                    dequeue.removeFirst();
                    dequeue.addFirst(board[i][j]*2);
                    dequeue.addFirst(0);
                }
            }
            for(int i=0; i<N; i++) {
                if(dequeue.isEmpty())
                    break;
                while(!dequeue.isEmpty()) {
                    int temp =  dequeue.removeLast();
                        if(temp != 0) {
                            up[i][j] = temp;
                            break;
                        }
                }
            }
        }

        int[][] down = new int[N][N];
        for(int j=0; j<N; j++) {
            for(int i=N-1; i>=0; i--) {
                if(board[i][j] == 0)
                    continue;
                else if(dequeue.isEmpty() || board[i][j] != dequeue.peekFirst()) {
                    dequeue.addFirst(board[i][j]);
                }
                else {
                    dequeue.removeFirst();
                    dequeue.addFirst(board[i][j]*2);
                    dequeue.addFirst(0);
                }
            }
            for(int i=N-1; i>=0; i--) {
                if(dequeue.isEmpty())
                    break;
                while(!dequeue.isEmpty()) {
                    int temp =  dequeue.removeLast();
                        if(temp != 0) {
                            down[i][j] = temp;
                            break;
                        }
                }
            }
        }
        
        dfs(right, depth+1);
        dfs(left, depth+1);
        dfs(up, depth+1);
        dfs(down, depth+1);
    }

    static int findMax(int[][] board) {
        int max = 0;
        for(int[] line: board) {
            for(int block: line) {
                if(max < block)
                    max = block;
            }
        }
        return max;
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
