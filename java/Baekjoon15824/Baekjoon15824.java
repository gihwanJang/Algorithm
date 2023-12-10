import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] nums;
    long[] powers;
    int MOD = 1_000_000_007;

    public Problem(int n) {
        this.n = n;
        nums = new int[n];
        powers = new long[n];
    }

    public long solve(){
        long add = 0;
        long sub = 0;
        makePower();
        Arrays.sort(nums);
        for(int i = 1; i < n; ++i) {
            add = (add + (powers[i] * nums[i])%MOD)%MOD;
            sub = (sub + (powers[i] * nums[n-i-1])%MOD)%MOD;
        }
        return (add + MOD - sub) % MOD;
    }

    private void makePower() {
        for(int i = 0, t = 1; i < n; ++i) {
            powers[i] = t-1;
            t *= 2;
            t %= MOD;
        }
    }
}

public class Baekjoon15824 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(problem.solve());
    }
}
