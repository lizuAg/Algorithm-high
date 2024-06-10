//백준 1916번 최소비용 구하기 (https://www.acmicpc.net/submit/1916/79459763)

import java.util.*;
import java.io.*;

class Main {
    static int N, M, A, B;
    static List<List<int[]>> roads = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        getInput();

        int[] costs = new int[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[A] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2)-> arr1[1] - arr2[1]);
        pq.add(new int[] {A, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            if(costs[curr[0]] < curr[1])
                continue;

            costs[curr[0]] = curr[1];

            for(int[] road: roads.get(curr[0])) {
                if(costs[road[0]] > road[1] + curr[1])
                    pq.add(new int[] {road[0], road[1] + curr[1]});
            }
        }

        System.out.println(costs[B]);
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) {
            roads.add(new ArrayList<>());
        }

