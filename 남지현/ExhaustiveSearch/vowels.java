import java.util.*;
class Solution {
    public int solution(String word) {
        List<String> vowels = new ArrayList<>(List.of("A", "E", "I", "O", "U"));
        int answer = 0;
        String[] letters = word.split("");
        for (int i = 0; i < letters.length; i++) {
            answer += vowels.indexOf(letters[i]) * number(4 - i) + 1;
        }
        return answer;
    }
    private int number(int idx) {
        int number = 0;
        for (int i = 0; i <= idx; i++) {
            number += Math.pow(5, i);
        }
        return number;
    }
}
