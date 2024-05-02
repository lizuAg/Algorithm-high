import java.util.*;

// map을 3개나 쓰는 문제 맞나요..?
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Song> list = new ArrayList<>();
        
        // 장르 : 총 개수
        // classic : 3, pop : 3
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            int v = map.getOrDefault(genres[i], 0);
            map.put(genres[i], v + 1);
        }
        
        // 장르 : 총 재생 수
        // classic : 1450, pop : 3100
        Map<String, Integer> sumMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            int v = sumMap.getOrDefault(genres[i], 0);
            sumMap.put(genres[i], v + plays[i]);
        }
        
        // Song 객체 생성
        for(int i = 0; i < genres.length; i++) {
            Song s = new Song(i, plays[i], map.get(genres[i]), sumMap.get(genres[i]), genres[i]);
            list.add(s);
        }
        
        // 정렬 기준에 맞게 정렬
        Collections.sort(list);
        
        // 장르 : 개수
        // 2개 이상이 되면 더는 수록하지 않는다.
        map.clear();
        
        List<Integer> res = new ArrayList<>();
        for(Song s : list) {
            map.put(s.name, map.getOrDefault(s.name, 0) + 1);
            if(map.get(s.name) > 2) continue;
            res.add(s.i);
        }
        
        // List to Array
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Song implements Comparable<Song> {
        int i;
        int cnt;
        int genreCnt;
        int sum;
        String name;
        
        Song(int i, int cnt, int genreCnt, int sum, String name) {
            this.i = i;
            this.cnt = cnt;
            this.genreCnt = genreCnt;
            this.sum = sum;
            this.name = name;
        }
        
        public int compareTo(Song s) {
            if(this.sum != s.sum) return s.sum - this.sum;
            if(this.cnt == s.cnt) {
                if(this.genreCnt == s.genreCnt) {
                    return this.i - s.i;
                }
                else {
                    return s.genreCnt - this.genreCnt;
                }
            }
            return s.cnt - this.cnt;
        }
    }
}
