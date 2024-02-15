import java.io.*;
import java.util.*;

class Problem {
    int n;
    int last;
    int[] nums;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.last = 0;
        this.nums = new int[2_000_001];
        this.n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int k = Integer.parseInt(st.nextToken());
            last = Math.max(last, k);
            ++nums[k];
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private long solve() {
        long ret = 0;

        for (int i = 1; i <= last; ++i) {
            int team = 0;
            long count = 0;

            for (int j = 1; j * i <= last; ++j) {
                if (nums[j * i] != 0) {
                    team += nums[j * i];
                    count += (long)i * nums[j * i];
                }
            }
            if (team > 1) {
                ret = Math.max(ret, count);
            }
        }
        return ret;
    }
}

public class Baekjoon1222 {
    public static void main(String[] args) {
        new Problem();
    }
}
