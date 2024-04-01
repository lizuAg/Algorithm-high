//BOJ 13549번 숨바꼭질 3 (https://www.acmicpc.net/submit/13549/76133212)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int END_POINT = 100000;
    static int[] map;
    static int K, N, answer;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[END_POINT+1];
        Arrays.fill(map, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        map[N] = 0;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            
            if(x == K)
                break;
            
            int next = x*2;
            if(next<=END_POINT && map[next] > map[x]) {
                map[next] = map[x];
                queue.offer(next);
            }

            next = x +1;
            if(next <= END_POINT && map[next] > map[x]+1) {
                map[next] = map[x] + 1;
                queue.offer(next);
            }
        
            next = x -1;
            if(next >= 0 && map[next] > map[x]+1) {
                map[next] = map[x] + 1;
                queue.offer(next);
            }
        }
        
        System.out.println(map[K]);
    }
}
