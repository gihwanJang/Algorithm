import java.io.*;
import java.util.*;

class Problem {
    int n, v, ans;
    int[] nums;
    int[][][] memo;

    public Problem(String n, String v) {
        this.n = Integer.parseInt(n);
        this.v = Integer.parseInt(v);
        this.ans = this.n;
        nums = new int[this.n];
        memo = new int[this.n][1001][1001];
        for(int i = 0; i < this.n; ++i) {
            for(int j = 0; j < 1001; ++j) {
                for(int k = 0; k < 1001; ++k) {
                    memo[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public int solve() {
        makeSolveCount(0, nums[0], nums[0], 1);
        return ans;
    }

    private void makeSolveCount(int curr, int min, int max, int cnt) {
        if(max - min >= v) {
            ans = Math.min(ans, cnt);
            return;
        }

        memo[curr][min][max] = cnt;

        for(int i = 1; i <= 2  && curr+i < n; ++i) {
            int next = curr + i;
            int nextMin = Math.min(min, nums[next]);
            int nextMax = Math.max(max, nums[next]);
            
            if(memo[curr][min][max]+1 < memo[next][nextMin][nextMax]) {
                makeSolveCount(next, nextMin, nextMax, cnt+1);
            }
        }
    }
}

public class Baekjoon1332 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p.n; ++i) {
            p.nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(p.solve());
    }
}
