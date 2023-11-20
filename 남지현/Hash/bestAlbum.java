import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Music>> musicMap = new HashMap<>();
        int numberOfMusic = genres.length;
        for (int i = 0; i < numberOfMusic; i++) {
            if (!musicMap.containsKey(genres[i]))
                musicMap.put(genres[i], new ArrayList<Music>());
            musicMap.get(genres[i]).add(new Music(i, genres[i], plays[i]));
        }
        List<Genre> genreSum = new ArrayList<>();
        for (String genreName: musicMap.keySet()) {
            int sum=0;
            for (Music music: musicMap.get(genreName)) {
                sum += music.playNumber;
            }
            genreSum.add(new Genre(genreName, sum));
        }
        genreSum.sort((g1, g2) -> g1.compareTo(g2));
        for (Genre type: genreSum) {
            musicMap.get(type.name).sort((m1, m2) -> m1.compareTo(m2));
            answer.add((musicMap.get(type.name).get(0).id));
            if (musicMap.get(type.name).size() >= 2)
                answer.add(musicMap.get(type.name).get(1).id);    
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Genre {
        String name;
        Integer playsSum;
        
        Genre(String name, int playsSum) {
            this.name = name;
            this.playsSum = playsSum;
        }
        
        int compareTo(Genre g) {
            return g.playsSum-this.playsSum;
        }
    }
    
    class Music {
        int id;
        String genre;
        Integer playNumber;
        
        Music(int id, String genre, int playNumber) {
            this.id = id;
            this.genre = genre;
            this.playNumber= playNumber;
        }
        
        int compareTo(Music m) {
            if (m.playNumber.equals(this.playNumber))
                return this.id-m.id;
            return m.playNumber-this.playNumber;
        }
    }
}
