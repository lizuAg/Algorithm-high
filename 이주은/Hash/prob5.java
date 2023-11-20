import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르별 총 재생 횟수 저장
        HashMap<String, Integer> cntMap = new HashMap<>();
        //장르별 노래 리스트 저장
        HashMap<String, List<Song>> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            if(!map.containsKey(genres[i]))
               map.put(genres[i], new ArrayList<>());
            
            map.get(genres[i]).add(new Song(i, plays[i]));
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //장르리스트 생성, 총 재생수 기준 정렬
        List<String> genreList = new ArrayList<>(cntMap.keySet());
        genreList.sort((o1, o2) -> cntMap.get(o2).compareTo(cntMap.get(o1)));

        //정답 리스트
        ArrayList<Integer> list = new ArrayList<>();
        for(String genre : genreList) {
            List<Song> songs = map.get(genre);
            Collections.sort(songs, Collections.reverseOrder());
            
            list.add(songs.get(0).id);
            //장르에 속한 곡이 하나라면, 하나의 곡만 선택
            if(songs.size() > 1)
                list.add(songs.get(1).id);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) 
            answer[i] = list.get(i).intValue();
        return answer;
    }
}

class Song implements Comparable<Song> {
    int id, play;
    
    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song other) {
        return play - other.play;
    }
}