import java.util.HashMap;

class Hash3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String phone : phone_book) {
            map.put(phone, 1);
        }
        
        // 타겟 전화번호를 substring으로 잘라서 해당 문자열을 map이 가지고 있으면 false 리턴
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
