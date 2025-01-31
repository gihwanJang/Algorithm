import java.io.*;
import java.util.*;

class Problem {
    private StringBuilder sb;
    private int n, m;
    private char[][] classroom;
    private int[][] memo;

    public Problem() {
        try {
            sb = new StringBuilder();
            input();
            System.out.print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            classroom = new char[n][m];
            for (int r = 0; r < n; ++r) {
                classroom[r] = br.readLine().toCharArray();
            }
            solve();
        }
    }

    private void solve() {
        List<Integer> rowMasks = new ArrayList<>();
        int allMask = (1 << m) - 1;

        for (int r = 0; r < n; ++r) {
            int mask = 0;
            for (int c = 0; c < m; ++c) {
                if (classroom[r][c] == '.') {
                    mask |= (1 << c);
                }
            }
            rowMasks.add(mask);
        }

        memo = new int[n][1<<m];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));
        sb.append(dfs(0, 0, rowMasks)).append('\n');
    }

    private int dfs(int row, int prevMask, List<Integer> rowMasks) {
        if (row == n) {
            return 0;
        } else if (memo[row][prevMask] != -1) {
            return memo[row][prevMask];
        }

        int maxStudents = 0;
        int validMask = rowMasks.get(row);

        for (int currMask = validMask; currMask >= 0; currMask = (currMask - 1) & validMask) {
            if (isValid(currMask) && isValidWithPrev(prevMask, currMask)) {
                maxStudents = Math.max(maxStudents, Integer.bitCount(currMask) + dfs(row + 1, currMask, rowMasks));
            }
            if (currMask == 0) break;
        }
        return memo[row][prevMask] = maxStudents;

    }

    private boolean isValid(int mask) {
        return (mask & (mask >> 1)) == 0;
    }

    private boolean isValidWithPrev(int prevMask, int currMask) {
        return (prevMask & (currMask >> 1)) == 0 && (prevMask & (currMask << 1)) == 0;
    }
}

public class Baekjoon1014 {
    public static void main(String[] args) {
        new Problem();
    }
}
