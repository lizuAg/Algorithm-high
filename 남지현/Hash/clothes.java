import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> clothesMap = new HashMap<>();
        for (String[] element: clothes) {
            if (!clothesMap.containsKey(element[1])) {
                clothesMap.put(element[1], new ArrayList<String>());
            }
            clothesMap.get(element[1]).add(element[0]);
        }
        
        for (String clothesType: clothesMap.keySet()) {
            int number = clothesMap.get(clothesType).size();
            answer *= number+1;
        }
        return answer-1;
    }
}
