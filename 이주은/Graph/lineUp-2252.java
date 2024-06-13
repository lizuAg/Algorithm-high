//백준 2252번 줄 세우기

import java.util.*;
import java.io.*;

class Main {
    //0. 그래프정보(인접행렬^^?), 진입차수, 진입차수가 0인 노드를 담을 배열이 필요
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] indegrees;
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //1. getInput
        getInput();
        
        //2. 진입차수가 0인 노드를 먼저 큐에 넣는다.
        for(int i=1; i<=N; i ++) {
            if(indegrees[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int a = queue.poll();

            //3. 진입차수가 0인 노드를 먼저 출력한다.
            bw.write(a+" ");
            
            //4. 꺼낸 노드가 선행 노드인 다른 노드들에 대해 진입차수를 줄이고,
            //진입차수가 0인 노드를 큐에 추가한다.
            for(int b : graph.get(a)) {
                indegrees[b]--;

                if(indegrees[b] == 0)
                    queue.add(b);
            }
        }
        bw.flush();
    }
    
    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        indegrees = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            indegrees[b]++;
        }
    }
}
