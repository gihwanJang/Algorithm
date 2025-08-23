import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();
    private static final int ROW = 10;
    private static final int COL = 9;
    private static final int[][] ONE_STEP_MOVES = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    private static final int[][][] TWO_STEP_MOVES = {
        {{1,1}, {1,-1}},
        {{-1,1}, {-1,-1}},
        {{1,1}, {-1,1}},
        {{1,-1}, {-1,-1}}
    };

    private int[] sang, king;

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
        sang = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        king = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void solve() {
        boolean[][] visited = new boolean[ROW][COL];
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[]{sang[0], sang[1], 0});
        visited[sang[0]][sang[1]] = true;
        while (!que.isEmpty()) {
            int[] curr = que.poll();

            if (king[0] == curr[0] && king[1] == curr[1]) {
                ANSWER.append(curr[2]);
                return;
            }

            for (int i = 0; i < 4; ++i) {
                int[] one = {curr[0] + ONE_STEP_MOVES[i][0], curr[1] + ONE_STEP_MOVES[i][1]};
                if (isValidate(one[0], one[1]) && !(king[0] == one[0] && king[1] == one[1])) {
                    for (int j = 0; j < 2; ++j) {
                        int[] two = canMove(i, one, j);
                        if (two != null && !visited[two[0]][two[1]]) {
                            que.add(new int[]{two[0], two[1], curr[2] + 1});
                            visited[two[0]][two[1]] = true;
                        }
                    }
                }
            }
        }
        ANSWER.append(-1);
    }

    private int[] canMove(int dir, int[] loc, int next) {
        int[] towLoc = new int[]{loc[0], loc[1]};
        towLoc[0] += TWO_STEP_MOVES[dir][next][0];
        towLoc[1] += TWO_STEP_MOVES[dir][next][1];
        if (!isValidate(towLoc[0], towLoc[1]) ||
            (king[0] == towLoc[0] && king[1] == towLoc[1])) {
            return null;
        }
        towLoc[0] += TWO_STEP_MOVES[dir][next][0];
        towLoc[1] += TWO_STEP_MOVES[dir][next][1];
        if (!isValidate(towLoc[0], towLoc[1])) {
            return null;
        }
        return towLoc;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < ROW &&
                0 <= c && c < COL);
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon16509 {
    public static void main(String[] args) {
        new Problem();
    }
}
