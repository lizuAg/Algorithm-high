//[BOJ] 거북이 🐢 (https://www.acmicpc.net/submit/8911/77502576)

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<String> controls = new ArrayList<>();

    //북(F, B), 동 (..), 남(..), 서(..)
    static int[] dx = {0, 0, 1, -1, 0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 0, 0};

    static int L=0, R=0, U=0, D=0;
    
    public static void main(String[] args) throws IOException {
        input();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(String control: controls) {
            L=0; R=0; U=0; D=0;
            
            goTurtle(control);
            
            int a = Math.abs(L) + R;
            int b = Math.abs(D) + U;
            int area = a*b;
            
            bw.write(area+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void goTurtle(String control) {
        int len = control.length();
        int[] curr = new int[] {0, 0};
        int direction = 0;
            
        for(int i=0; i<len; i++) {
            switch (control.charAt(i)) {
                case 'F':
                    curr[0] += dx[direction];
                    curr[1] += dy[direction];
                    break;
                case 'B':
                    curr[0] += dx[direction+1];
                    curr[1] += dy[direction+1];
                    break;
                case 'L':
                    direction = (direction + 2) % 8;
                    break;
                case 'R':
                    direction = (direction + 6) % 8;
                    break;
            }
            L = Math.min(L, curr[0]);
            R = Math.max(R, curr[0]);
            U = Math.max(U, curr[1]);
            D = Math.min(D, curr[1]);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            controls.add(br.readLine());
        }
        br.close();
    }
}
