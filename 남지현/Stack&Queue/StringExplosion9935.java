import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str = bf.readLine().toCharArray();
        char[] explosion = bf.readLine().toCharArray();
        int explosionLength = explosion.length;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<str.length; i++) {
            stack.add(str[i]);
            if (stack.size() >= explosionLength) {
                boolean present = true;
                for (int j=0; j<explosionLength; j++) {
                    if (stack.get(stack.size()-explosionLength+j) != explosion[j]) {
                        present = false;
                        break;
                    }
                }
                if (present) {
                    for (int j=0; j<explosionLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c: stack) {
            answer.append(c);
        }
        if (answer.length() == 0) {
            answer.append("FRULA");
        }
        System.out.println(answer.toString());
    }
}
