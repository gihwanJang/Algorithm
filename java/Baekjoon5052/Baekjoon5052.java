import java.io.*;
import java.util.*;

class Problem {
    int n;
    String[] nums;
    public Problem(int n) {
        this.n = n;
        nums = new String[n];
    }
    public String solve() {
        Arrays.sort(nums);
        for(int i = 1; i < n; ++i) {
            if(nums[i-1].length() <= nums[i].length()) {
                if(isSubString(i-1, i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    private boolean isSubString(int i, int j) {
        for(int k = 0; k < nums[i].length(); ++k) {
            if(nums[i].charAt(k) != nums[j].charAt(k)) {
                return false;
            }
        }
        return true;
    }
}

public class Baekjoon5052 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            Problem p = new Problem(Integer.parseInt(br.readLine()));

            for(int i = 0; i < p.n; ++i) {
                p.nums[i] = br.readLine();
            }

            sb.append(p.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
