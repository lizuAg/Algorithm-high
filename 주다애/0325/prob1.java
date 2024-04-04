// 구현에만 치중함 -> 정규표현식 공부 필요
class Solution {
    static String answer;
    public String solution(String new_id) {
        answer = "";
        stepOne(new_id);
        answer = steptwo();
        stepThreeAndFour();
        if(answer.length() == 0) answer = "a";
        if(answer.length() >= 16) stepSix();
        if(answer.length() <= 2) stepSeven();
        return answer;
    }
    
    // 1. 대문자 -> 소문자
    static void stepOne(String new_id) {
        int len = new_id.length();
        for(int i = 0; i < len; i++) {
            char t = new_id.charAt(i);
            if(t >= 65 && t <= 90) {
                answer += Character.toLowerCase(t);
                continue;
            }
            answer += t;
        }
    }
    
    // 2. 제거
    static String steptwo() {
        String s = "";
        int len = answer.length();
        for(int i = 0; i < len; i++) {
            char t = answer.charAt(i);
            if(t >= 97 && t <= 122) {
                s += t;
                continue;
            }
            if(t == '-' || t == '_' || t == '.') {
                s += t;
                continue;
            }
            if(t >= 48 && t <= 57) {
                s += t;
                continue;
            }
        }
        return s;
    }
    
    // 3+4. (마침표 관련)
    static void stepThreeAndFour() {
        answer = answer.replaceAll("[..]+", ".");
        // 첫번째 마침표 제거
        if(answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if(answer.length() == 0) return;
        // 마지막 마침표 제거
        if(answer.charAt(answer.length() - 1) == '.') {
            if(answer.length() == 1) {
                answer = "";
                return;
            }
            answer = answer.substring(0, answer.length() - 1);
        }
    }
    
    // 6. 길이 제한 + 마지막 마침표 제거
    static void stepSix() {
        answer = answer.substring(0, 15);
        if(answer.charAt(14) == '.') answer = answer.substring(0, 14);
    }
    
    // 7. 3글자 만들기
    static void stepSeven() {
        int len = answer.length();
        char t = answer.charAt(len - 1);
        while(answer.length() < 3) {
            answer += t;
        }
    }
}
