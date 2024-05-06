import java.util.*;

class Solution {
  
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        
        HashMap<String, List<Music>> musicMap = new HashMap<>();
        for (int i=0; i<len; i++) {
            if (! musicMap.containsKey(genres[i])) {
                musicMap.put(genres[i], new ArrayList<>());
            }
            musicMap.get(genres[i]).add(new Music(i, plays[i]));
        }
        
        List<int[]> genreList = new ArrayList<>();
        for (Map.Entry<String, List<Music>> entry: musicMap.entrySet()) {
            int sum = 0;
            int genreIdx = entry.getValue().get(0).id;
            for (Music music: entry.getValue()) {
                sum += music.playNumber;
            }
            genreList.add(new int[]{genreIdx, sum});
        }
        Collections.sort(genreList, (arr1, arr2) -> arr2[1]-arr1[1]);
        
        List<Music> musics = new ArrayList<>();
        for (int[] g: genreList) {
            List<Music> e = musicMap.get(genres[g[0]]);
            if (e.size() == 1) {
                musics.add(e.get(0));
                continue;
            } else {
                e.sort((m1, m2) -> m1.compareTo(m2));
                musics.add(e.get(0));
                musics.add(e.get(1));
            }
        }
        
        return musics.stream().mapToInt(m -> m.id).toArray();
    }
    
    static class Music {
        int id;
        int playNumber;
        
        Music(int id, int playNumber) {
            this.id = id;
            this.playNumber= playNumber;
        }
        
        int compareTo(Music m) {
            return m.playNumber==this.playNumber? this.id-m.id : m.playNumber-this.playNumber;
        }
    }
}
