import java.io.*;

class Problem {
    private int n;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    }

    private void output() {
        System.out.println(n > 1023 ? -1 : solve());
    }

    private long solve() {
        byte[] nums = new byte[10];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; ++i) {
            update(nums, (byte) 0);
        }
        for (int i = 9; i >= 0; --i) {
            sb.append(nums[i]);
        }
        return Long.valueOf(sb.toString());
    }

    private void update(byte[] nums, byte digit) {
        ++nums[digit];
        if ((nums[digit] > 9) || (digit < 9 && nums[digit + 1] == nums[digit])) {
            nums[digit] = digit;
            if (digit < 9) {
                if (nums[digit + 1] == 0) {
                    nums[digit + 1] = digit;
                }
                update(nums, (byte) (digit + 1));
            }
        }
    }
}

public class Baekjoon1174 {
    public static void main(String[] args) {
        new Problem();
    }
}
