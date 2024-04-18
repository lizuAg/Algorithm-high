//BOJ 1700번 멀티탭 스케줄링 (https://www.acmicpc.net/submit/1700/76552405)

import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] order;

    public static class PowerStrip {
        Set<Integer> set;
        int max;

        public PowerStrip(int max) {
            this.set = new HashSet<Integer>();
            this.max = max;
        }

        public boolean plugIn(int x) {
            if(set.contains(x) || set.size() < max) {            
                set.add(x);
                return true;
            }
            return false;
        }

        public void unplug(int next) {
            Set<Integer> copy = new HashSet<>(set);
            
            for(int i=next; i<K; i++) {
                if(copy.size() == 1)
                    break;
                copy.remove(order[i]);
            }
            int x = copy.iterator().next();
            set.remove(x);
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
    
        PowerStrip ps = new PowerStrip(N);
        int answer = 0;
        for(int i=0; i<K; i++) {
            if(!ps.plugIn(order[i])) {
                answer++;
                ps.unplug(i+1);
                ps.plugIn(order[i]);
            }
        }
    
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        order = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }
}
