import java.io.*;
import java.util.*;

class Problem {
    int n;
    int[] nums;
    public Problem(int n) {
        this.n = n;
        nums = new int[n];
    }
    public String solve() {
        int a, b;

        if(n < 2) {
            return "A";
        } else if(n == 2){
            if(nums[0] == nums[1]) {
                return String.valueOf(nums[0]);
            } else {
                return "A";
            }
        } else {
            if(nums[0] == nums[1]) {
                a = 1;
                b = 0;
            } else {
                if(Math.abs(nums[1] - nums[2]) % Math.abs(nums[0] - nums[1]) != 0) {
                    return "B";
                }
                a = (nums[1] - nums[2]) / (nums[0] - nums[1]);
                b = nums[1] - nums[0] * a;
            }
        }

        for(int i = 2; i < n; ++i) {
            if(nums[i-1] * a + b != nums[i]) {
                return "B";
            }
        }
        return String.valueOf(nums[n-1] * a + b);
    }
}

public class Baekjoon1111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p.n; ++i) {
            p.nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(p.solve());
    }
}
