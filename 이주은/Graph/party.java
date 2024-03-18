//BOJ 1238(https://www.acmicpc.net/submit/1238/75200007)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        int[][] graph = new int[N][N];

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                if(i==j)
                    graph[i][i] = 0;
                else
                    graph[i][j] = Integer.MAX_VALUE;
            }


        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());

            graph[start][end] = time;
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(graph[i][k]==Integer.MAX_VALUE || graph[k][j]==Integer.MAX_VALUE)
                        continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            int temp = graph[i][X] + graph[X][i];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}
