import java.io.*;
import java.util.*;

class Problem {
    int n, m, lo, hi;
    int[] nums;

    public Problem(String n, String m) {
        this.lo = 0;
        this.hi = 0;
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        nums = new int[this.n];
    }

    public int solve() {
        int ans = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isPossible(mid)) {
                ans = Math.min(ans, mid);
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int target) {
        int cnt = 0, sum = 0;
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            if(sum > target) {
                ++cnt;
                sum = nums[i];
            }
        }
        return cnt+1 <= m;
    }
}

public class Baekjoon2343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
            problem.hi += problem.nums[i];
            problem.lo = Math.max(problem.lo, problem.nums[i]);
        }

        System.out.println(problem.solve());
    }
}
