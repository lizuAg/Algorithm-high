import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> numberMap = new HashMap<>();
        List<String> phoneBook = Arrays.asList(phone_book);
        phoneBook.forEach(number -> numberMap.put(number, 1));
        for (String number : phoneBook) {
            int length = number.length();
            for (int i=1; i<length; i++) {
                if (numberMap.containsKey(number.substring(0, i)))
                    return false;
            }
        }
        return answer;
    }
}
