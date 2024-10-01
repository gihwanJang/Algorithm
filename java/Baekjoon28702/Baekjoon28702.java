import java.io.*;
import java.util.*;

class Problem {
    private int nums;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 3; i > 0; --i) { 
            String s = br.readLine();
            if (s.charAt(0) != 'F' && s.charAt(0) != 'B') {
                nums = Integer.parseInt(s) + i;
            }
        }
        solve();
    }

    private void solve() {
        if (nums % 3 == 0) {
            if (nums % 5 == 0) {
                System.out.println("FizzBuzz");
                return;
            }
            System.out.println("Fizz");
            return;
        } else if (nums % 5 == 0) {
            System.out.println("Buzz");
            return;
        }
        System.out.println(nums);
    }
}

public class Baekjoon28702 {
    public static void main(String[] args) {
        new Problem();
    }
}
