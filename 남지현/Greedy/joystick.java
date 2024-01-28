import java.util.*;
class Solution {
    public int solution(String name) {
        int count = 0;
        int move = name.length()-1;
        for(int i = 0; i < name.length(); i++) {
            count += Math.min(name.charAt(i)-'A', 1+'Z'-name.charAt(i));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i+1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i*2+(name.length()-endA));
                move = Math.min(move, i+(name.length()-endA)*2);
            }
        }
        return count + move;
    }
}
