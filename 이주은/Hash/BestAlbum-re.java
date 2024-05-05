//[프로그래머스] 베스트 앨범 (https://school.programmers.co.kr/learn/courses/30/lessons/42579)

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        HashMap<String, PriorityQueue<int[]>> map = new HashMap<>();
        HashMap<String, Integer> totalPlays = new HashMap<>();
        
        for(int i=0; i<n; i++) {     
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            
            //[0] : 재생 횟수. [1] : 고유번호
            PriorityQueue<int[]> songs = map.getOrDefault(genres[i], new PriorityQueue<int[]>((arr1, arr2)-> arr1[0] != arr2[0] ? arr2[0] - arr1[0] : arr1[1] - arr2[1]));
            songs.add(new int[] {plays[i], i});
            map.put(genres[i], songs);
        }
        
        List<String> keys = new ArrayList<>(totalPlays.keySet());
        Collections.sort(keys, (s1, s2) -> totalPlays.get(s2) - totalPlays.get(s1));
        
        
        ArrayList<Integer> best = new ArrayList<>();
        for(String key: keys) {
            PriorityQueue<int[]> songs = map.get(key);
            int[] song = songs.poll();            
            best.add(song[1]);
            
            if(songs.isEmpty()) continue;
            
            song = songs.poll();            
            best.add(song[1]);
        }
        
        int[] answer = new int[best.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = best.get(i);
        } 
        
        return answer;
    }
}
