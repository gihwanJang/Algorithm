import java.io.*;
import java.util.*;

class Problem {

    int n, m, a;
    int[] nums;

    public Problem(String n, String m, String a) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        this.a = Integer.parseInt(a);
        this.nums = new int[this.n];
    }

    public int solve() {
        Arrays.sort(nums);
        int s = nums[0];
        int e = nums[n-1];
        int mid, score;
        int ret = Integer.MAX_VALUE;

        while(s <= e) {
            mid = s + (e - s) / 2;
            score = getScore(mid) - mid;
            
            if(score < a) {
                s = mid + 1;
            } else {
                e = mid - 1;
                ret = Math.min(score, ret);
            }
        }
        return ret;
    }

    private int getScore(int score) {
        int curr = score;
        for(int i = 0; i < m; ++i) {
            if(a <= curr - score) {
                return curr;
            }

            if(nums[lowerBound(curr)] <= curr) {
                curr += nums[lowerBound(curr)];
            } else {
                return curr;
            }
        }
        return curr;
    }

    private int lowerBound(int v) {
        int m;
        int s = 0;
        int e = n-1;

        while(s <= e) {
            m = s + (e - s) / 2;
            if (nums[m] == v) {
                return m;
            } else if (nums[m] < v) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        
        return e < 0 ? 0 : e;
    }
}

public class Baekjoon31264 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken(), st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p.n; ++i) {
            p.nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(p.solve());
    }

}
