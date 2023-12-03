import java.io.*;

class Problem {
    int n;
    int[] nums;

    public Problem(int n) {
        this.n = n;
        nums = new int[n];
    }

    public int solve() {
        for(int i = 1; i <= 1000; ++i) {
            if(isPossible(i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPossible(int cnt) {
        for(int i = 0; i < n; ++i) {
            if (!isPossible(cnt, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPossible(int cnt, int idx) {
        int lo = 0;
        int hi = 10 * cnt;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int avg = (mid * 1000) / cnt;
            
            if (avg == nums[idx]) {
                if (avg <= 10 * 1000) {
                    return true;
                }
            }
            
            if (avg > nums[idx]) {
                hi = (mid - 1);
            } else {
                lo = (mid + 1);
            }
        }

        return false;
    }
}

public class Baekjoon1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < problem.n; ++i) {
            String[] temp = br.readLine().split("\\.");
            problem.nums[i] = Integer.parseInt(temp[0] + temp[1]);
        }

        System.out.println(problem.solve());
    }
}
