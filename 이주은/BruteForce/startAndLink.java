//BOJ 14889번 스타트와 링크

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int limit;
    static int[][] stats;
    static ArrayList<Integer> start = new ArrayList<>();
    static ArrayList<Integer> link = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int now) {
        if(now == N) {
            calc();
            return;
        }

        if(start.size() < limit) {
            start.add(now);
            dfs(now+1);
            start.remove(Integer.valueOf(now));
        }
        if(link.size() < limit) {
            link.add(now);
            dfs(now+1);
            link.remove(Integer.valueOf(now));
        }
    }

    public static void calc() {
        int sumS = 0;
        int sumL = 0;

        for(int i=0; i<limit; i++) {
            int a = start.get(i);
            for(int j=0; j<limit; j++) {
                if(i==j)
                    continue;
                
                int b = start.get(j);
                sumS += stats[a][b];
            }
        }

        for(int i=0; i<limit; i++) {
            int a = link.get(i);
            for(int j=0; j<limit; j++) {
                if(i==j)
                    continue;
                
                int b = link.get(j);
                sumL += stats[a][b];
            }
        }

        answer = Math.min(answer, Math.abs(sumS - sumL));
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        limit = N/2;

        stats = new int[N][N];
        
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                stats[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
