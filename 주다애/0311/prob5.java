import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static String res = "";
    public int solution(String s) {
        map = new HashMap<>();
        initialize();
        String alpha = "";
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(97 <= s.charAt(i) && s.charAt(i) <= 122) {
                alpha += s.charAt(i);
                if(map.getOrDefault(alpha, 10) != 10) {
                    changeToNum(alpha);
                    alpha = "";
                }
                continue;
            }
            else {
                res += s.charAt(i);
            }
        }
        return Integer.valueOf(res);
    }
    
    private void initialize() {
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
    }
    
    private void changeToNum(String alpha) {
        res += map.get(alpha);
    }
}
