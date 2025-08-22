import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();
    private static final int[] dr = {-1,1,0,0};
    private static final int[] dc = {0,0,-1,1};

    private int[][] map;
    private int[] start;

    public Problem() {
        try {
            input();
            solve();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        start = new int[2];
        for (int i = 0; i < 5; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        start = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        int[] visited = new int[5];
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[]{start[0], start[1], 0});
        while (!que.isEmpty()) {
            int[] loc = que.poll();

            if(map[loc[0]][loc[1]] == 1) {
                ANSWER.append(loc[2]);
                return;
            }

            if ((visited[loc[0]] & (1 << loc[1])) == 0) {
                visited[loc[0]] = visited[loc[0]] | 1 << loc[1];
                for (int i = 0; i < 4; ++i) {
                    int nextR = loc[0] + dr[i];
                    int nextC = loc[1] + dc[i];
                    if (isValidate(nextR, nextC) && map[nextR][nextC] != -1) {
                        que.add(new int[]{nextR, nextC, loc[2] + 1});
                    }
                }
            }
        }

        ANSWER.append(-1);
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < 5 &&
                0 <= c && c < 5);
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon25416 {
    public static void main(String[] args) {
        new Problem();
    }
}
