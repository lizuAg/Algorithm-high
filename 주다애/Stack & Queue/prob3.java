import java.util.Stack;

class Prob3 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        
        int size = s.length();
        
        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '(') {
                stack.push(")");
            }
            else if(stack.isEmpty() || !stack.pop().equals(")")) {
                return false;
            }
        }
        // for loop이 끝났는데도 비어있지 않으면 false
        if(!stack.isEmpty()) return false;
        return true;
    }
}
