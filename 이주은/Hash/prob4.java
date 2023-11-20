import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap();
        
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        
        int answer = 1;
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            answer *= entry.getValue();
        }
        return answer -1;
    }
}