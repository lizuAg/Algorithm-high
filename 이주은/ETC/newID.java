//[프로그래머스] 신규 아이디 추천 (https://school.programmers.co.kr/learn/courses/30/lessons/72410)

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();    

        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        new_id = new_id.replaceAll("\\.+", ".");

        new_id = new_id.replaceAll("^\\.|\\.$", "");

        if(new_id.isEmpty())
            new_id = "a";
        else if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }
        
        char last = new_id.charAt(new_id.length()-1);
        while(new_id.length() < 3) {
            new_id += last;
        }
        
        return new_id;
    }
}
