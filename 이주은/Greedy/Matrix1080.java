//BOJ 1080번 행렬 (https://www.acmicpc.net/submit/1080/77331773)

import java.util.*;
import java.io.*;

class Main {
    static int[][] A;
    static int[][] B;
    static int N, M;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        input();

        for(int i=0; i<N-2; i++) {
            for(int j=0; j<M-2; j++) {
                if(A[i][j] == B[i][j])
                    continue;

                flip(i, j);
                answer++;
            }
        }

        answer = check() ? answer : -1;

        System.out.println(answer);
    }
    
    static void flip(int i, int j) {
        for(int k=0; k<3; k++) {
            for(int l=0; l<3; l++) {
                A[i+k][j+l] = (A[i+k][j+l]+1)%2;
            }
        }
    }

    static boolean check() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != B[i][j])
                    return false;
            }
        }
        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        A = new int[N][M];
        B = new int[N][M];
        
        for(int i=0; i<N; i++) {
            line = br.readLine().split("");
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i=0; i<N; i++) {
            line = br.readLine().split("");
            for(int j=0; j<M; j++) {
                B[i][j] = Integer.parseInt(line[j]);
            }
        }

        br.close();
    }
}
