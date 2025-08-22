import java.io.*;
import java.util.*;

class Location {
    int r;
    int c;

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Problem {
    int n;
    int d;
    int[][] map;
    boolean[][] rowVisited;
    boolean[][] colVisited;

    public Problem(String n, String d) {
        this.n = Integer.parseInt(n);
        this.d = Integer.parseInt(d);
        this.map = new int[this.n][this.n];
        this.rowVisited = new boolean[this.n][this.d];
        this.colVisited = new boolean[this.n][this.d];
        initMap();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();

        fillMap(new Location(n - d + 1, n - d + 1));
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean fillMap(Location loc) {
        if(loc.r == n) {
            return true;
        }
        
        for (int i = 0; i < d; ++i) {
            if(!rowVisited[loc.r][i] && !colVisited[loc.c][i]) {
                rowVisited[loc.r][i] = true;
                colVisited[loc.c][i] = true;
                map[loc.r][loc.c] = i;
                if(fillMap(getNextLocation(loc))) {
                    return true;
                }
                map[loc.r][loc.c] = 0;
                rowVisited[loc.r][i] = false;
                colVisited[loc.c][i] = false;
            }
        }
        return false;
    }

    private Location getNextLocation(Location curr) {
        Location next = new Location(curr.r, curr.c + 1);

        if (n == next.c) {
            next.c = n-d+1;
            ++next.r;
        }
        return next;
    }

    private void initMap() {
        for(int i = 0; i <= n-d; ++i)
            for(int j = n-1, k = d-1; k >= 0; --j, --k) {
                map[i][j] = map[j][i] = k;
                rowVisited[i][k] = true;
                rowVisited[j][k] = true;
                colVisited[i][k] = true;
                colVisited[j][k] = true;
            }
    }
}

public class Baekjoon1481 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken());

        System.out.println(p.solve());
    }
}
