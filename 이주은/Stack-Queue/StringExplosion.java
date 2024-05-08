//백준 9935번 문자열 폭발 (https://www.acmicpc.net/submit/9935/77942197)

import java.util.*;
import java.io.*;

class Main {
    static String str;
    static String explosion;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String explosion = br.readLine();
        char last = explosion.charAt(explosion.length()-1);

        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            deque.addLast(c);

            if((c != last) || deque.size()<explosion.length())
                continue;

            boolean flag = true;
            for(int j=explosion.length()-1; j>=0; j--) {
                char t = deque.removeLast();
                temp.addLast(t);
                if(t != explosion.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                temp.clear();
                continue;   
            }

            
            while(!temp.isEmpty()) {
                deque.addLast(temp.removeLast());
            }
        }

        if(deque.isEmpty()) {
            System.out.println("FRULA");
        }
        
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);
    }
}
