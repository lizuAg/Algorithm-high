import java.util.*;

class Solution {
    Map<String, Integer> scores;
    public String solution(String[] survey, int[] choices) {
        scores = new HashMap<>();
        setMap();
        int N = survey.length;
        for (int i=0; i<N; i++) {
            String[] types = survey[i].split("");
            int score = choices[i]-4;
            if (score < 0) {
                scores.put(types[0], scores.get(types[0])+Math.abs(score));
            } else {
                scores.put(types[1], scores.get(types[1])+score);
            }
        }
        return type();
    }
    
    private void setMap() {
        scores.put("R", 0);
        scores.put("T", 0);
        scores.put("C", 0);
        scores.put("F", 0);
        scores.put("J", 0);
        scores.put("M", 0);
        scores.put("A", 0);
        scores.put("N", 0);
    }
    
    private String type() {
        StringBuilder builder = new StringBuilder();
        if (scores.get("T") > scores.get("R")) {
            builder.append("T");
        } else {
            builder.append("R");
        }
        
        if (scores.get("F") > scores.get("C")) {
            builder.append("F");
        } else {
            builder.append("C");
        }
        
        if (scores.get("M") > scores.get("J")) {
            builder.append("M");
        } else {
            builder.append("J");
        }
        
        if (scores.get("N") > scores.get("A")) {
            builder.append("N");
        } else {
            builder.append("A");
        }
        
        return builder.toString();
    }
}
