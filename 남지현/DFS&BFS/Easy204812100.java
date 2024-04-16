import java.util.*;
import java.io.*;

//2048 (Easy) - 12100

class Main {
    static int N;
    static int answer = 0;
    static int[][] board;

    private static void dfs(List<Integer> directions) {
        if (directions.size()==5) {
            int[][] copy = deepCopyArray(board);
            for (int dir: directions) {
                move(dir, copy);
            }
            answer = Math.max(answer, findMax(copy));
            return;
        }
        for (int i=0; i<4; i++) {
            List<Integer> tmp = new ArrayList<>(directions);
            tmp.add(i);
            dfs(tmp);
        }
    }

    private static int findMax(int[][] arr) {
        int max = 0;
        for (int[] row: arr) {
            for (int e: row) {
                max = Math.max(max, e);
            }
        }
        return max;
    }
    
    private static void move(int dir, int[][] arr) {
        if (dir == 0) {
            pushUp(arr);
            joinUp(arr);
            pushUp(arr);
        } else if (dir == 1) {
            pushDown(arr);
            joinDown(arr);
            pushDown(arr);
        } else if (dir == 2) {
            pushLeft(arr);
            joinLeft(arr);
            pushLeft(arr);
        } else if (dir == 3) {
            pushRight(arr);
            joinRight(arr);
            pushRight(arr);
        }
    }
    
    private static void pushUp(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[j][i] != 0) {
                    int idx = j-1;
                    while (idx >=0 && arr[idx][i]==0) {
                        idx--;
                    }
                    if (idx != j-1) {
                        arr[idx+1][i] = arr[j][i];
                        arr[j][i] = 0;
                    }
                }
            }
        }
    }

    private static void joinUp(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-1; j++) {
                if (arr[j][i] == arr[j+1][i]) {
                    arr[j][i] += arr[j+1][i];
                    arr[j+1][i] = 0;
                }
            }
        }
    }

    private static void pushDown(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=N-1; j>=0; j--) {
                if (arr[j][i] != 0) {
                    int idx = j+1;
                    while (idx<N && arr[idx][i]==0) {
                        idx++;
                    }
                    if (idx != j+1) {
                        arr[idx-1][i] = arr[j][i];
                        arr[j][i] = 0;
                    }
                }
            }
        }
    }

    private static void joinDown(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=N-1; j>0; j--) {
                if (arr[j][i] == arr[j-1][i]) {
                    arr[j][i] += arr[j-1][i];
                    arr[j-1][i] = 0;
                }
            }
        }
    }

    private static void pushLeft(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] != 0) {
                    int idx = j-1;
                    while (idx >=0 && arr[i][idx]==0) {
                        idx--;
                    }
                    if (idx != j-1) {
                        arr[i][idx+1] = arr[i][j];
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void joinLeft(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N-1; j++) {
                if (arr[i][j] == arr[i][j+1]) {
                    arr[i][j] += arr[i][j+1];
                    arr[i][j+1] = 0;
                }
            }
        }
    }

    private static void pushRight(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=N-1; j>=0; j--) {
                if (arr[i][j] != 0) {
                    int idx = j+1;
                    while (idx < N && arr[i][idx]==0) {
                        idx++;
                    }
                    if (idx != j+1) {
                        arr[i][idx-1] = arr[i][j];
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void joinRight(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=N-1; j>0; j--) {
                if (arr[i][j] == arr[i][j-1]) {
                    arr[i][j] += arr[i][j-1];
                    arr[i][j-1] = 0;
                }
            }
        }
    }

    private static int[][] deepCopyArray(int[][] before) {
        int[][] after = new int[N][N];
        for (int i=0; i<N; i++) {
            after[i] = Arrays.copyOf(before[i], N);
        }
        return after;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        dfs(new ArrayList<>());
        System.out.println(answer);
    }
}
