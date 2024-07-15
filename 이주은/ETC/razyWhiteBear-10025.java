//백준 10025번 게으른 백곰

import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int answer;
    static int[] map = new int[100]

    static final int LEN = 100001;
    
    public static void main(String[] args) throws IOException {
        getInput();
        solve();
        
        System.out.println(answer);
    }

    private static void solve() {
        int sum = 0;
        int window = K*2 + 1;
        boolean flag = false;

        for(int i=0; i<LEN; i++) {

            if(i== window-1) flag = true;
            if(i >= window) {
                sum -= map[i-window];
            }

            sum += map[i];

            if(flag && sum > answer) {
                answer = sum;
            }
        }
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");

            int g = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);

            map[x] = g;
        }
    }
}
