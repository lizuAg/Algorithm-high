//백준 12015번 가장 긴 증가하는 부분 수열 2 (https://www.acmicpc.net/submit/12015/79009265)

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] inputs;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        getInput();

        List<Integer> dp = new ArrayList<>();
        dp.add(inputs[0]);
        
        for(int i=1; i<N; i++) {
            int start = 0, end = dp.size()-1, mid;
            if(inputs[i] > dp.get(end)) {
                dp.add(inputs[i]);
                continue;
            }

            while (start < end) {
                mid = (start + end)/2;

                if(dp.get(mid) < inputs[i])
                    start = mid + 1;
                else
                    end = mid;
            }
            dp.set(end, inputs[i]);
        }
        
        System.out.println(dp.size());
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputs = new int[N];
    
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            inputs[i] = Integer.parseInt(line[i]);
        }
        
        br.close();
    }
}
