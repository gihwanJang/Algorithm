import java.io.*;
import java.util.*;

class Problem {
    private StringBuilder SB = new StringBuilder();

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
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int[] size = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            char[][] map = new char[size[0]][size[1]];
            for (int i = 0; i < map.length; ++i) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); ++j) {
                    map[i][j] = s.charAt(j);
                }
            }
            solve(map, t);
        }
    }

    private void solve(char[][] map, int t) {
        SB.append("Case #").append(t).append(":\n");

        for (int r = 0; r < map.length; ++r) {
            for (int c = 0; c < map[r].length; ++c) {
                if (map[r][c] == '#') {
                    if (isValidate(r, c + 1, map) && map[r][c + 1] == '#' &&
                        isValidate(r + 1, c, map) && map[r + 1][c] == '#' &&
                        isValidate(r + 1, c + 1, map) && map[r + 1][c + 1] == '#') {
                        map[r][c] = '/';
                        map[r][c + 1] = '\\';
                        map[r + 1][c] = '\\';
                        map[r + 1][c + 1] = '/';
                    } else {
                        SB.append("Impossible").append("\n");
                        return;
                    }
                }
            }
        }

        for (int r = 0; r < map.length; ++r) {
            for (int c = 0; c < map[r].length; ++c) {
                SB.append(map[r][c]);
            }
            SB.append("\n");
        }
    }

    private boolean isValidate(int r, int c, char[][] map) {
        return (0 <= r && r < map.length &&
                0 <= c && c < map[0].length);
    }

    private void output() {
        System.out.print(SB.toString());
    }
}

public class Baekjoon12492 {
    public static void main(String[] args) {
        new Problem();
    }
}
