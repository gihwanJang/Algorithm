import java.io.*;
import java.util.*;

class Problem {
    private String[][] map;

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

        map = new String[10][10];
        for (int i = 0; i < 10; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; ++j) {
                map[i][j] = st.nextToken();
            }
        }
    }

    private void output() {
        if (solve()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private boolean solve() {
        for (int r = 0; r < 10; ++r) {
            boolean flag = true;

            for (int c = 0; c < 9; ++c) {
                if (!map[r][c].equals(map[r][c + 1])) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        for (int c = 0; c < 10; ++c) {
            boolean flag = true;

            for (int r = 0; r < 9; ++r) {
                if (!map[r][c].equals(map[r + 1][c])) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}

public class A {
    public static void main(String[] args) {
        new Problem();
    }
}
