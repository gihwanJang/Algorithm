import java.io.*;
import java.util.*;

class Location {
    int r,c;
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Problem {
    int n, m;
    int[][] map;
    int[] dx = {0,0,1,0,-1};
    int[] dy = {0,1,0,-1,0};
    List<Integer> canRow;

    public Problem(int n, int m) {
        this.n = n;
        this.m = m;
        map = new int[n][m];
        canRow = new ArrayList<>();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        for(int r = 0; r < n; ++r)
            if(move(r))
                canRow.add(r+1);

        sb.append(canRow.size()).append("\n");
        for(int i = 0; i < canRow.size(); ++i)
            sb.append(canRow.get(i)).append(" ");

        return sb.toString();
    }

    private boolean move(int r) {
        int dir = 1;
        Location curr = new Location(r, 0);
        int[][] visited = new int[n][m];
        
        while(isValidate(curr.r, curr.c)) {
            if(visited[curr.r][curr.c] == dir) return true;

            visited[curr.r][curr.c] = dir;

            int nextR = curr.r + dx[dir] * map[curr.r][curr.c];
            int nextC = curr.c + dy[dir++] * map[curr.r][curr.c];
            curr = new Location(nextR, nextC);

            if(dir == 5) dir = 1;
        }

        return false;
    }

    private boolean isValidate(int r, int c) {
        return (
            0 <= r && r < n
            &&
            0 <= c && c < m
        );
    }
}

public class Yellow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int r = 0; r < problem.n; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < problem.m; ++c) {
                problem.map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(problem.solve());
    }
}
