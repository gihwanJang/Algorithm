import java.io.*;
import java.util.*;

class Problem {
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};
    private final char[] direction = {'U', 'D', 'L', 'R'};

    private int n;
    private int ans;
    private int[][] map;
    private boolean[][] visited;
    private String maxString;
    

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

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        ans = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        solve(0, 0, new ArrayDeque<>(), 0);
        visited[0][0] = true;
        System.out.println(ans + map[0][0]);
        System.out.println(maxString);
    }

    private void solve(int r, int c, ArrayDeque<Integer> deque, int score) {
        if (r == n-1 && c == n-1) {
            if (ans < score) {
                StringBuilder sb = new StringBuilder();
                ans = score;
                for (int idx : deque) {
                    sb.append(direction[idx]);
                }
                maxString = sb.toString();
            }
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (isValidate(nextR, nextC) && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                deque.add(i);
                solve(nextR, nextC, deque, score + map[nextR][nextC]);
                deque.pollLast();
                visited[nextR][nextC] = false;
            }
        }
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < n && 0 <= c && c < n);
    }
}

public class Baekjoon1861 {
    public static void main(String[] args) {
        new Problem();
    }
}
