import java.io.*;
import java.util.*;

class Problem {
    private int n, m;
    private int[][] map;

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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int r = 0; r < n; ++r) {
            map[r] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int size = 0;

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                if (map[r][c] != 0 && r > 0 && c > 0) {
                    map[r][c] = Math.min(map[r-1][c], Math.min(map[r][c-1], map[r-1][c-1])) + 1;
                }
                size = Math.max(size, map[r][c]);
            }
        }
        return size * size;
    }
}

public class Baekjoon1915 {
    public static void main(String[] args) {
        new Problem();
    }
}
