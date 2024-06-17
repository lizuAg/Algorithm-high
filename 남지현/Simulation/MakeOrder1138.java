import java.util.*;
import java.io.*;

// 백준1138 - 한 줄로 서기

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int idx = 0;
            int count = -1;
            while (count<n) {
                if (answer[idx] == -1) count++;
                idx++;
            }
            answer[idx-1] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int e: answer) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);
    }
}
