import java.io.*;
import java.util.*;

class Problem {
    private static final int[] DR = {-1,1,0,0};
    private static final int[] DC = {0,0,-1,1};

    private int rowSize;
    private int colSize;
    private int[][] board;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        board = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; ++i) {
            board[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int[][] fullPool = getFullPool();

        for (int level = 9; level > 0; --level) {
            for (int r = 0; r < rowSize; ++r) {
                for (int c = 0; c < colSize; ++c) {
                    if (fullPool[r][c] != board[r][c] && 
                        fullPool[r][c] == level && 
                        isFlowDown(fullPool, r, c)) {
                            flowDown(fullPool, r, c);
                    }
                }
            }
        }
        return getDifference(fullPool);
    }

    private int getDifference(int[][] fullPool) {
        int count = 0;

        for (int r = 0; r < rowSize; ++r) {
            for (int c = 0; c < colSize; ++c) {
                count += fullPool[r][c] - board[r][c];
            }
        }
        return count;
    }

    private int[][] getFullPool() {
        int[][] fullPool = new int[rowSize][colSize];

        for (int r = 0; r < rowSize; ++r) {
            Arrays.fill(fullPool[r], 9);
        }
        return fullPool;
    }

    private void flowDown(int[][] fullPool, int r, int c) {
        int level = fullPool[r][c];
        int[] curr = {r, c};
        Queue<int[]> que = new ArrayDeque<>();

        que.add(curr);
        while (!que.isEmpty()) {
            curr = que.poll();

            if (fullPool[curr[0]][curr[1]] != board[curr[0]][curr[1]] && 
                fullPool[curr[0]][curr[1]] == level) {
                fullPool[curr[0]][curr[1]] -= 1;
                for (int i = 0; i < 4; ++i) {
                    int adjacentR = curr[0] + DR[i];
                    int adjacentC = curr[1] + DC[i];

                    if (isValidate(adjacentR, adjacentC) && 
                        fullPool[adjacentR][adjacentC] == level) {
                        que.add(new int[]{adjacentR, adjacentC});
                    }
                }
            }
        }
    }

    private boolean isFlowDown(int[][] fullPool, int r, int c) {
        for (int i = 0; i < 4; ++i) {
            int adjacentR = r + DR[i];
            int adjacentC = c + DC[i];

            if (!isValidate(adjacentR, adjacentC) || 
                fullPool[r][c] > fullPool[adjacentR][adjacentC]) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < rowSize &&
                0 <= c && c < colSize);
    }
}

public class Baekjoon1113 {
    public static void main(String[] args) {
        new Problem();
    }
}
