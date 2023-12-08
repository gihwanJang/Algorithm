import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] nums;

    public Problem(int n) {
        this.n = n;
        nums = new int[n];
    }

    public int solve() {
        int s, e, min = 4;

        s = e = 0;
        Arrays.sort(nums);
        while (true) {
            if (e >= n) {
                break;
            }
            if (nums[e] - nums[s] < 5) {
                ++e;
                min = Math.min(min, 5 - e + s);
            } else {
                s++;
            }
        }

        return min;
    }
}

public class Baekjoon1337 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));

        for (int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(problem.solve());
    }
}
