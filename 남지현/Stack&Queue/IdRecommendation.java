class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        answer = answer.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        answer = answer.replaceAll("\\.+", ".");
        answer = trim(answer);
        
        if (answer.length() == 0)
            answer = "a";
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                answer+=answer.charAt(answer.length()-1);
            }
        }
        answer = trim(answer);
        return answer;
    }
    
    private String trim(String input) {
        while (input.length() > 0 && input.charAt(0) == '.') {
            input = input.substring(1);
        }
        while (input.length() > 0 && input.charAt(input.length()-1) == '.') {
            input = input.substring(0, input.length()-1);
        }
        return input;
    }
}
