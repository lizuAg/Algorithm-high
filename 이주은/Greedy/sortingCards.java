//백준 1715번 카드 정렬하기 (https://www.acmicpc.net/submit/1715/78950826)

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        while(pq.size() != 1) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
