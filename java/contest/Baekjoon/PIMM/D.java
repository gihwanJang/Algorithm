import java.io.*;
import java.util.*;

class QueInfo {
    int r, c, d;

    public QueInfo(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Problem {
    private int n;
    private int m;
    private boolean map[][];
    private boolean visited[][];

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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m];
        for (int k = Integer.parseInt(st.nextToken()); k > 0; --k) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
    }

    private void output() {
        System.out.println(BFS());
    }

    private int BFS() {
        int[] even_dr = {-1,-1, 1,1,0,0};
        int[] even_dc = {-1, 0,-1,0,1,-1};
        int[] odd_dr = {-1,-1,1,1,0,0};
        int[] odd_dc = { 0, 1,0,1,1,-1};
        QueInfo curr;
        Queue<QueInfo> que = new ArrayDeque<>();

        visited[0][0] = true;
        que.add(new QueInfo(0, 0, 0));
        while (!que.isEmpty()) {
            curr = que.poll();

            if (curr.r == n-1 && curr.c == m-1) {
                return curr.d;
            }

            for (int i = 0; i < 6; ++i) {
                int nextR = curr.r + ((curr.r % 2 == 0) ? even_dr[i] : odd_dr[i]);
                int nextC = curr.c + ((curr.r % 2 == 0) ? even_dc[i] : odd_dc[i]);

                if (isValidate(nextR, nextC)) {
                    visited[nextR][nextC] = true;
                    que.add(new QueInfo(nextR, nextC, curr.d + 1));
                }
            }
        }
        return -1;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n
                &&
                0 <= c && c < m
                &&
                !map[r][c]
                &&
                !visited[r][c]);
    }
}

public class D {
    public static void main(String[] args) {
        new Problem();
    }
}