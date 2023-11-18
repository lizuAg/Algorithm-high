import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> players = new HashMap<>();
        for (String name : participant) {
            if (players.containsKey(name)) {
                players.put(name, players.get(name)+1);
            } else {
                players.put(name, 1);
            }
        }
        for (String completionName : completion) {
            players.put(completionName, players.get(completionName)-1);
        }
        for (String key : players.keySet()) {
            if (players.get(key) == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
