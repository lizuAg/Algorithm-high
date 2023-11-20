import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String phone : phone_book)
            map.put(phone, 0);
        
        for(String phone : phone_book){
            int i = phone.length();
            for(int j=1; j<i; j++){
                if(map.containsKey(phone.substring(0, j)))
                    return false;
            }
        }
        return true;
    }
}