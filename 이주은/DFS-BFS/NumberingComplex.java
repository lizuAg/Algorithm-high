import java.io.*;
import java.util.*;

class Main {
    static boolean[][] map, visited;
    static int complexCnt = 0, houseCnt, N;

    public static void dfs(int i, int j){
        visited[i][j] = true;
        houseCnt ++;
        
        if(i+1 < N && map[i+1][j] && !visited[i+1][j])
            dfs(i+1, j);
        if(i > 0 && map[i-1][j] && !visited[i-1][j])
            dfs(i-1, j);
        if(j+1 < N && map[i][j+1] && !visited[i][j+1])
            dfs(i, j+1);
        if(j > 0 && map[i][j-1] && !visited[i][j-1])
            dfs(i, j-1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++)
                map[i][j] = input[j].equals("1") ? true : false;
        }
        br.close();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] && !visited[i][j]){
                    complexCnt++;
                    houseCnt = 0;
                    dfs(i, j);
                    list.add(houseCnt);
                }
            }
        }
        
        Collections.sort(list);        
        bw.append(complexCnt + "\n");
		for(Integer i : list) {
			bw.append(i + "\n");
		}

		bw.flush();
		bw.close();	
    }
}
