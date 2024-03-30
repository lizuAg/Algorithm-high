//BOJ 21608번 상어 초등학교(https://www.acmicpc.net/submit/21608/75676080)

import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Set<Integer>> bfMap = new HashMap<>();
    static int[] students;
    static int[][] seats;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int N, N2, result;
    static class Seat implements Comparable<Seat> {
        int r, c, bfCnt, emptyCnt;

        Seat(int r, int c, int bfCnt, int emptyCnt) {
            this.r = r;
            this.c = c;
            this.bfCnt = bfCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Seat o) {
            if(this.bfCnt == o.bfCnt){
                if(this.emptyCnt == o.emptyCnt){
                    if(this.r == o.r)
                        return this.c - o.c;
                    else
                        return this.r - this.r;
                }
                return o.emptyCnt - this.emptyCnt;
            }
            return o.bfCnt - this.bfCnt;        
        }
    }
    
    public static void main(String[] args) throws IOException {
        int answer = 0;
        
        input();

        seats[1][1] = students[0];
        for(int i=1; i<N2; i++) {
            chooseSeat(students[i]);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer += getSatisfaction(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void chooseSeat(int st) {
        PriorityQueue<Seat> pq = new PriorityQueue<Seat>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(seats[i][j] != 0)
                    continue;
                pq.add(getCandidateSeat(i, j, st));
            }
        }
        
        Seat seat = pq.poll();
        seats[seat.r][seat.c] = st;
    }

    private static Seat getCandidateSeat(int r, int c, int st) {
        int bfCnt=0, emptyCnt=0;
        
        for(int i=0; i<4; i++){
            int currR = r + dx[i];
            int currC = c + dy[i];

            if(currR < 0 || currR >= N || currC < 0 || currC >= N)
                continue;

            int fr = seats[currR][currC];
            if(fr == 0){
                emptyCnt++;
                continue;
            }
            if(bfMap.get(st).contains(fr))
                bfCnt++;
        }
        return new Seat(r, c, bfCnt, emptyCnt);
    }

    private static int getSatisfaction(int r, int c) {
        int st = seats[r][c];
        int bfCnt = 0;
        
        for(int i=0; i<4; i++) {
            int currR = r + dx[i];
            int currC = c + dy[i];

            if(currR < 0 || currR >= N || currC < 0 || currC >= N)
                continue;
            
            int fr = seats[currR][currC];

            if(bfMap.get(st).contains(fr))
                bfCnt++;
        }
        
        if(bfCnt == 4)
            return 1000;
        if(bfCnt == 3)
            return 100;
        if(bfCnt == 2)
            return 10;
        if(bfCnt == 1)
            return 1;
        return 0;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        N2 = N*N;
        students = new int[N2];
        seats = new int[N][N];
        
        for(int i=0; i<N2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
        
            for(int j=0; j<4; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            bfMap.put(students[i], set);
        }
    }
}
