import java.io.*;
import java.util.*;

class Problem {
    private int n, l;
    private int[][] map;

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
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (canCrossRow(i)) {
                ++cnt;
                System.out.println("row : " + i);
            }
            if (canCrossCol(i)) {
                ++cnt;
                System.out.println("col : " + i);
            }
        }
        return cnt;
    }

    private boolean canCrossRow(int row) {
        boolean[] used = new boolean[n];

        for (int c = 0; c < n - 1; ++c) {
            if (map[row][c] != map[row][c + 1]) {
                if (Math.abs(map[row][c] - map[row][c + 1]) > 1) {
                    return false;
                }

                if (map[row][c] > map[row][c+1]) {
                    int heigh = map[row][c+1];

                    for (int i = 0; i < l; ++i) {
                        if (c + 1 + i >= n || used[c + 1 + i] || map[row][c + 1 + i] != heigh) {
                            return false;
                        }
                        used[c + 1 + i] = true;
                    }
                } else {
                    int heigh = map[row][c];

                    for (int i = 0; i < l; ++i) {
                        if (c - i < 0 || used[c - i] || map[row][c - i] != heigh) {
                            return false;
                        }
                        used[c - i] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean canCrossCol(int col) {
        boolean[] used = new boolean[n];

        for (int r = 0; r < n - 1; ++r) {
            if (map[r][col] != map[r+1][col]) {
                if (Math.abs(map[r][col] - map[r + 1][col]) > 1) {
                    return false;
                }

                if (map[r][col] > map[r+1][col]) {
                    int heigh = map[r + 1][col];

                    for (int i = 0; i < l; ++i) {
                        if (r + 1 + i >= n || used[r + 1 + i] || map[r + 1 + i][col] != heigh) {
                            return false;
                        }
                        used[r + 1 + i] = true;
                    }
                } else {
                    int heigh = map[r][col];;

                    for (int i = 0; i < l; ++i) {
                        if (r - i < 0 || used[r - i] || map[r - i][col] != heigh) {
                            return false;
                        }
                        used[r - i] = true;
                    }
                }
            }
        } 
        return true;
    }
}

public class Baekjoon14890 {
    public static void main(String[] args) {
        new Problem();
    }
}
