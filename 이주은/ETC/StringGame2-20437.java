//백준 20437번 문자열게임 2

import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static public void main(String[] args) throws Exception {
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            solve();
        }

        System.out.print(sb.toString());
    }

    static private void solve() throws Exception {
        int min = Integer.MAX_VALUE, max = -1;
        String w = br.readLine();
        int K = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];

        for(int i=0; i<w.length(); i++) {
            alpha[w.charAt(i) - 'a']++;
        }

        for(int i=0; i <= w.length() - K; i++) {
            int cnt = 0, len = 0;
            
            if(alpha[w.charAt(i) - 'a'] < K)
                continue;

            for(int win=0; i + win < w.length(); win++) {
                len++;
                
                if(w.charAt(i) != w.charAt(i + win))
                    continue;
                
                cnt++;

                if(cnt != K)
                    continue;

                if(min > len)
                    min = len;
                if(max < len)
                    max = len;
            }
        }

        if(min == Integer.MAX_VALUE || max == -1)
            sb.append(-1).append("\n");
        else
            sb.append(min).append(" ").append(max).append("\n");
    }
}
