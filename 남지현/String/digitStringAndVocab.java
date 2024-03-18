import java.util.*;
class Solution {
    public int solution(String s) {
        Map<String, Integer> dict = setDict();
        StringBuilder buffer = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (String letter: s.split("")) {
            try {
                int number = Integer.parseInt(letter);
                answer.append(number);
            } catch (NumberFormatException e) {
                buffer.append(letter);
                if (dict.containsKey(buffer.toString())) {
                    answer.append(dict.get(buffer.toString()));
                    buffer = new StringBuilder();
                }
            }
            
        }
        return Integer.parseInt(answer.toString());
    }
    
    private Map<String, Integer> setDict() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        return map;
    }
}
