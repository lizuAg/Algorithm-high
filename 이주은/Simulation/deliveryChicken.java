import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<House> hList;
    static List<House> cList;
    static int n, m;
    static int result = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] village = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer lineTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                village[i][j] = Integer.parseInt(lineTokenizer.nextToken());
            }
        }
        
        
        hList = new ArrayList<>();
        cList = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(village[i][j] == 1)
                    hList.add(new House(i, j));
                else if(village[i][j] == 2)
                    cList.add(new House(i, j));
            }
        }
        
        visited = new boolean[cList.size()];
        dfs(0, 0);
        
        System.out.println(result);
    }
    
    public static void dfs(int start, int cnt) {
        if(cnt == m) {
            int villDistance = 0;
            
            for(int i=0; i<hList.size(); i++) {
                int houseDistance = Integer.MAX_VALUE;
                
                for(int j=0; j<cList.size(); j++) {
                    if(visited[j]) {
                        int distance = Math.abs(hList.get(i).r - cList.get(j).r) + Math.abs(hList.get(i).c - cList.get(j).c);
                        houseDistance = Math.min(houseDistance, distance);
                    }
                }
                villDistance += houseDistance;
            }
            result = Math.min(result, villDistance);
        }
        
        for(int i=start; i<cList.size(); i++){
            visited[i] = true;
            dfs(i+1, cnt+1);
            visited[i] = false;
        }
    }
    
    public static class House {
        int r, c;
    
        public House(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
