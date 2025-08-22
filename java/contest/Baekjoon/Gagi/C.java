import java.io.*;
import java.util.*;

class Problem {
    private final int MOD = 1_000_000_007;

    private int R, C, k;
    private boolean map[][];
    private int visited[][][][];

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()) + 1;
        C = Integer.parseInt(st.nextToken()) + 1;
        k = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        visited = new int[R][C][R][C];
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = true;
        }
    }

    private void output() {
        System.out.println(DFS(0,0, 0, 0));
    }

    private int DFS(int r, int c, int down, int right) {
        if (r == R-1 && c == C-1) {
            return 0;
        } else if (visited[r][c][down][right] != 0) {
            return visited[r][c][down][right];
        }

        int count = 0;
        if (if () isValidate(r + 1, c)) {
            count = (DFS(r + 1, c, down + 1, right) + 1) % MOD;
        }
        if (isValidate(r, c + 1)) {
            count = (DFS(r, c + 1, down, right  +1) + 1) % MOD;
        }
        return visited[r][c][down][right] = count;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < R
                &&
                0 <= c && c < C);
    }
}

public class C {
    public static void main(String[] args) {
        new Problem();
    }
}
