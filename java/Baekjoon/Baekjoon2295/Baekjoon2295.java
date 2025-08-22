import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int[] nums;
    private Set<Integer> set;
    private List<Integer> sumList;

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

        nums = new int[n];
        set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
            set.add(nums[i]);
        }
        solve();
    }

    private void solve() {
        int idx = 0;
        makeSumList();

        Arrays.sort(nums);
        for (Integer s : sumList) {
            for (int i = idx; i < n; ++i) {
                int pick = nums[i] - s;
                if (set.contains(pick) && nums[idx] < nums[i]) {
                    idx = i;
                }
            }
        }
        System.out.println(nums[idx]);
    }

    private void makeSumList() {
        sumList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                sumList.add(nums[i] + nums[j]);
            }
        }
    }
}

public class Baekjoon2295 {
    public static void main(String[] args) {
        new Problem();
    }
}
