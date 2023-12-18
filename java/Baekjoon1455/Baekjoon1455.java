import java.io.*;
import java.util.*;

class Problem {
    int n, m;
    boolean[][] map;

    public Problem(String n, String m) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        map = new boolean[this.n][this.m];
    }

    public int solve() {
        int cnt = 0;
        for(int r = n-1; r >= 0; --r) {
            for(int c = m-1; c >= 0; --c) {
                if(!map[r][c]) {
                    reverse(r, c);
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private void reverse(int a, int b) {
        for(int r = 0; r <= a; ++r) {
            for(int c = 0; c <= b; ++c) {
                map[r][c] = !map[r][c];
            }
        }
    }
}

public class Baekjoon1455 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            String s = br.readLine();
            for(int j = 0; j <problem.m; ++j) {
                problem.map[i][j] = s.charAt(j) == '0';
            }
        }

        System.out.println(problem.solve());
    }
}
