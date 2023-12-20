import java.io.*;
import java.util.*;

class Problem {
    int n, m, k;
    boolean[][] matrix;

    public Problem(String n, String m) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        matrix = new boolean[this.n][this.m];
    }

    public int solve() {
        int ret = 0;
        for(int r = 0; r < n; ++r) {
            int zero = getZeroCnt(r);
            if(zero <= k && zero%2 == k%2) {
                ret = Math.max(ret, getRowCnt(r));
            }
        }
        return ret;
    }

    private int getZeroCnt(int r) {
        int cnt = 0;
        for (int c = 0; c < m; ++c) {
            if (!matrix[r][c]) {
                ++cnt;
            }
        }
        return cnt;
    }

    private int getRowCnt(int r) {
        int cnt = 0;
        for(int c_r = 0; c_r < n; ++c_r) {
            if(isEquals(r, c_r)) {
                ++cnt;
            }
        }
        return cnt;
    }

    private boolean isEquals(int r, int c_r) {
        for(int c = 0; c < m; ++c) {
            if(matrix[r][c] != matrix[c_r][c]) {
                return false;
            }
        }
        return true;
    }
}

public class Baekjoon1034 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            String s = br.readLine();
            for(int j = 0; j < problem.m; ++j) {
                problem.matrix[i][j] = s.charAt(j) == '1';
            }
        }
        problem.k = Integer.parseInt(br.readLine());

        System.out.println(problem.solve());
    }
}
