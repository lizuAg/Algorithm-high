//백준 1202번 보석 도둑(https://www.acmicpc.net/submit/1202/78730404)

import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[][] jewels;
    static int[] bags;
    
    public static void main(String[] args) throws Exception {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        input();

        int j = 0;
        for(int b=0; b<K; b++) {
            for(; j<N; j++) {
                if(bags[b] >= jewels[j][0]){
                    pq.add(jewels[j][1]);
                }
                else{
                    break;
                } 
            }
            if(!pq.isEmpty())
                answer += pq.poll();
        }
        System.out.println(answer);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        jewels = new int[N][2];
        bags = new int[K];

        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");

            jewels[i][0] = Integer.parseInt(line[0]); //무게
            jewels[i][1] = Integer.parseInt(line[1]); //가치
        }
        
        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a1, a2) -> a1[0] - a2[0] );
        Arrays.sort(bags);
    }
}
