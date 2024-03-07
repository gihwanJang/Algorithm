import java.io.*;
import java.util.*;

class Problem {
    private static final int[] DR = {1,0,0};
    private static final int[] DC = {0,1,-1};

    private int n, m;
    private int[][] map;
    private int[][][] dist;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());
        this.map = new int[n][m];
        this.dist = new int[n][m][3];
        for (int i = 0; i < n; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            for (int j = 0; j < m; ++j) {
                Arrays.fill(dist[i][j], -1000000000);
            }
        }
    }

    private void output() {
        System.out.println(DFS(0,0,0));
    }

    private int DFS(int r, int c, int dir) {
        if (r == n - 1 && c == m - 1) {
            return map[r][c];
        } else if (dist[r][c][dir] != -1000000000) {
            return dist[r][c][dir];
        }

        int value = -1000000000;
        for (int i = 0; i < 3; ++i) {
            if (!(dir == 1 && i == 2)
                && !(dir == 2 && i == 1)
                && isValidate(r + DR[i], c + DC[i])) {
                value = Math.max(value, DFS(r + DR[i], c + DC[i], i) + map[r][c]);
            }
        }
        return dist[r][c][dir] = value;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c < m);
    }
}

public class Baekjoon2169 {
    public static void main(String[] args) {
        new Problem();
    }
}
