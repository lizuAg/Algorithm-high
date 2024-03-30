import java.util.*;

class Solution {
    // R T / C F / J M / A N
    static Map<String, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = choices.length;
        for(int i = 0; i < len; i++) {
            calculateScore(survey[i].charAt(0), survey[i].charAt(1), choices[i]);
        }
        answer += decide("RT");
        answer += decide("CF");
        answer += decide("JM");
        answer += decide("AN");
        return answer;
    }
    
    private static String decide(String mbti) {
        int fv = map.getOrDefault(mbti.charAt(0)+"", 0);
        int sv = map.getOrDefault(mbti.charAt(1)+"", 0);
        if(fv < sv) {
            return mbti.charAt(1)+"";
        }
        return mbti.charAt(0)+"";
    }
    
    private static void calculateScore(char first, char second, int score) {
        int mbtiScore = score - 4;
        
        int fv = map.getOrDefault(first+"", 0);
        map.put(first+"", fv - mbtiScore);
        
        int sv = map.getOrDefault(second+"", 0);
        map.put(second+"", sv + mbtiScore);
    }
}
