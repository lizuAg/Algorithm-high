//[백준] 14501번 퇴사 (https://www.acmicpc.net/submit/14501/75492808)

import java.io.*;
import java.util.*;

public class Main {
    static int N, answer=0;
    static int[] times;
    static int[] pays;

    public static void dfs(int start, int remain, int pay) {
        boolean isOver = true;

        for(int i=start; i<N; i++) {
            if(times[i] <= remain){
                dfs(i+times[i], remain-times[i], pay+pays[i]);
                isOver = false;
            }
            remain--;
        }

        if(isOver){
            answer = answer < pay ? pay : answer;
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        times = new int[N];
        pays = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        dfs(0, N, 0);

        System.out.println(answer);
    }
}
