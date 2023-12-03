import java.util.*;

class Hash5 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 Map 생성
        Map<String, Integer> genreTotalPlay = new HashMap<>();
        // 장르별로 노래 정보를 저장할 Map 생성
        Map<String, List<Song>> songInfo = new HashMap<>();

        // 모든 노래에 대해 장르별 총 재생 횟수 계산하고, 노래 정보 저장
        for(int i = 0; i < genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];

            genreTotalPlay.put(genre, genreTotalPlay.getOrDefault(genre, 0) + play);
            songInfo.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        // 장르별로 노래를 재생 횟수와 고유 번호 순으로 정렬
        for (Map.Entry<String, List<Song>> entry : songInfo.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // 장르를 총 재생 횟수 순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotalPlay.keySet());
        sortedGenres.sort((s1, s2) -> genreTotalPlay.get(s2).compareTo(genreTotalPlay.get(s1)));

        List<Integer> answer = new ArrayList<>();

        // 각 장르에서 가장 많이 재생된 노래 최대 두 개씩 선택
        for(String genre : sortedGenres) {
            List<Song> songs = songInfo.get(genre);
            for(int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i).idx);
            }
        }

        // 결과를 배열로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }

    // 노래 정보를 저장할 클래스
    class Song implements Comparable<Song> {
        int idx, play;

        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            // 재생 횟수가 같으면 고유 번호가 낮은 순, 그렇지 않으면 재생 횟수가 높은 순으로 정렬
            return this.play == o.play ? this.idx - o.idx : o.play - this.play;
        }
    }
}
