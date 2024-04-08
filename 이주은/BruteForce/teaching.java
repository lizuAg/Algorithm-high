// BOJ 1062번 가르침 (https://www.acmicpc.net/submit/1062/76582563)

import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int answer = 0;
    static boolean[] alpha = new boolean[26];
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 5;

        if(K<0) {
            System.out.println("0");
            return;
        } else if(K == 21) {
            System.out.println(N);
            return;
        }
        
        words = new String[N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            str = str.substring(4, str.length()-4);
            words[i] = str;
        }

        alpha['a' - 'a'] = true;
        alpha['c' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        
        DFS(0, 0);
        System.out.println(answer);
    }

    static void func(int start, int depth) {
        if(depth == K) {
            int temp = count();
            answer = Math.max(temp, answer);
        }
        
        for(int i=start; i<26; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                DFS(i+1, depth+1);
                alpha[i] = false;
            }
        }
    }
    static int count() {
        int result = 0;

        for(String word: words) {
            if(isReadable(word))
                result ++;
        }
        return result;
    }
    static boolean isReadable(String word) {
        int len = word.length();
        
        for(int i=0; i<len; i++) {
            char c = word.charAt(i);
            if(!alpha[c - 'a'])
                return false;
        }
        return true;
    }
}
