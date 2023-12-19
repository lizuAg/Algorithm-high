import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strings = new ArrayList<>();
        Arrays.stream(numbers).forEach(number -> strings.add(String.valueOf(number)));
        strings.sort((str1, str2) -> (str2+str1).compareTo(str1+str2));
        StringBuilder builder = new StringBuilder();
        strings.forEach(builder::append);
        String answer = builder.toString();
        if (filledWithZero(answer))
            return "0";
        return answer;
    }
    
    private boolean filledWithZero(String input) {
        char[] chars = input.toCharArray();
        for (char l: chars) {
            if (l != '0')
                return false;
        }
        return true;
    }
}
