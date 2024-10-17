import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] nums;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        solve();
    }

    private void solve() {
        Arrays.sort(nums);

        int a = 0;
        int b = 1;
        for (int i = 0; i < nums.length; ++i) {
            int other = binarySearch(-nums[i]);
            if (i != other && Math.abs(nums[a]+nums[b]) > Math.abs(nums[i] + nums[other])) {
                a = i;
                b = other;
            }
            if (other < nums.length-1 && i != other+1 && Math.abs(nums[a]+nums[b]) > Math.abs(nums[i] + nums[other+1])) {
                a = i;
                b = other+1;
            }
            if (other > 0 && i != other-1 && Math.abs(nums[a]+nums[b]) > Math.abs(nums[i] + nums[other-1])) {
                a = i;
                b = other-1;
            }
        }
        if (a < b) {
            System.out.println(nums[a] + " " + nums[b]);
        } else {
            System.out.println(nums[b] + " " + nums[a]);
        }
    }

    private int binarySearch(int target) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return (lo >= nums.length ? nums.length-1 : lo);
    }
}

public class Baekjoon2470 {
    public static void main(String[] args) {
        new Problem();
    }
}
