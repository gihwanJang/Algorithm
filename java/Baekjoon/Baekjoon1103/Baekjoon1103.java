import java.io.*;
import java.util.*;

class Problem {
    int rSize;
    int cSize;
    int[][] map;
    int[][] memo;
    boolean[][] visited;

    final int[] dx = {0,0,-1,1};
    final int[] dy = {-1,1,0,0};

    public Problem() {
        input();
        output();
    }

    private int move(int r, int c) {
        if (!isValidate(r, c))  {
            return 0;
        } else if (visited[r][c]) {
            return -1;
        } else if (memo[r][c] != 0) {
            return memo[r][c];
        }

        visited[r][c] = true;
        for (int i = 0; i < 4; ++i) {
            int nextR = r + dx[i] * map[r][c];
            int nextC = c + dy[i] * map[r][c];
            int next = move(nextR, nextC);

            if (next == -1) {
                return memo[r][c] = -1;
            } else {
                memo[r][c] = Math.max(memo[r][c], next + 1);
            }
        }
        visited[r][c] = false;
        return memo[r][c];
    }

    private boolean isValidate(int r, int c) {
        return (0 <= r && r < rSize
                &&
                0 <= c && c < cSize
                &&
                map[r][c] != 0);
    }

    private void output() {
        System.out.println(move(0, 0));
    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            rSize = Integer.parseInt(st.nextToken());
            cSize = Integer.parseInt(st.nextToken());
            map = new int[rSize][cSize];
            memo = new int[rSize][cSize];
            visited = new boolean[rSize][cSize];
            for (int r = 0; r < rSize; ++r) {
                String in = br.readLine();

                for (int c = 0; c < cSize; ++c) {
                    map[r][c] = in.charAt(c) == 'H' ? 0 : (in.charAt(c) - '0');
                }
            }
        } catch (Exception e) {
        }
    }
}

public class Baekjoon1103 {
    public static void main(String[] args) {
        new Problem();
    }
}
