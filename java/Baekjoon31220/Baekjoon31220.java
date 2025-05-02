import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private boolean[][] map;

    public Problem() {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        map = new boolean[n][m];
        solve();
    }

    private void solve() {
        

        System.out.println("NO");
    }

    private void rowPaint(int rm, int cm) {
        if (n % 2 == 0) {

        } else {

        }
    }

    private void colPaint() {
        if (n % 2 == 0) {

        } else {

        }
    }

    private void output(boolean[][] map) {
        System.out.println("YES");
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                System.out.println(map[r][c] ? 1 : 0);
            }
            System.out.println();
        }
    }
}

public class Baekjoon31220 {
    public static void main(String[] args) {
        new Problem();
    }
}
