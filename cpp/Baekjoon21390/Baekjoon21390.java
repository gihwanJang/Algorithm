import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder SB = new StringBuilder();
    private Double[][] memo;

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
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            double max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] map = new int[row][col];
            memo = new Double[row][col];

            for (int r = 0; r < row; ++r) {
                String s = br.readLine();
                for (int c = 0; c < col; ++c) {
                    if (s.charAt(c) == '.') {
                        map[r][c] = 0;
                    } else if (s.charAt(c) == '*') {
                        map[r][c] = -1;
                    } else {
                        map[r][c] = s.charAt(c) - '0';
                    }
                }
            }

            for (int i = 0; i < col; ++i) {
                max = Math.max(max, solve(row, col, map, 0, i));
            }
            SB.append(String.format("%.9f", max)).append("\n");
        }
    }

    private double solve(int row, int col, int[][] map, int currR, int currC) {
        for (int r = currR; r < row; ++r) {
            if (map[r][currC] == -1) {
                if (memo[r][currC] != null) {
                    return memo[r][currC];
                }
                return (memo[r][currC] = (solve(row, col, map, r, currC-1) + solve(row, col, map, r, currC+1)) / 2);
            } else if (map[r][currC] > 0) {
                return map[r][currC];
            }
        }
        return 0;
    }

    private void output() {
        System.out.print(SB.toString());
    }
}

public class Baekjoon21390 {
    public static void main(String[] args) {
        new Problem();
    }
}
