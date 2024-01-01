import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[][] map, memo;
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public Problem(int n) {
        this.n = n;
        map = new int[n][n];
        memo = new int[n][n];
        visited = new boolean[n][n];
    }
    public int solve() {
        int max = 0;
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                if(!visited[r][c]) {
                    visited[r][c] = true;
                    DFS(r, c);
                }
                max = Math.max(max, memo[r][c]);
            }
        }
        return max+1;
    }
    private void DFS(int r, int c) {
        for(int i = 0; i < 4; ++i) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if(isValidate(nextR, nextC) && map[r][c] < map[nextR][nextC]) {
                if(!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    DFS(nextR, nextC);
                }
                memo[r][c] = Math.max(memo[r][c], memo[nextR][nextC]+1);
            }
        }
    }
    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c <n);
    }
}

public class Baekjoon1937 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));
        
        for(int r = 0; r < p.n; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < p.n; ++c) {
                p.map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(p.solve());
    }
}
