import java.io.*;
import java.util.*;

class Problem {
    private int[] NUMBER = {5, 7, 5, 7, 7};
    private StringBuilder sb = new StringBuilder();

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[] words = new int[n];
            for (int i = 0; i < n; ++i) {
                words[i] = br.readLine().length();
            }
            solve(words);
        }
    }

    private void solve(int[] words) {
        for (int i = 0; i < words.length; ++i) {
            if (isParse(words, i)) {
                sb.append(i + 1).append("\n");
                return;
            }
        }
        sb.append(-1).append("\n");
    }

    private boolean isParse(int[] words, int start) {
        int idx = 0;
        int count = 0;
        for (int i = start; i < words.length; ++i) {
            count += words[i];
            
            if (count > NUMBER[idx]) { // fail condition
                return false;
            } else if (count == NUMBER[idx]) { // next step condition
                if (idx == 4) { // exit condition
                    return true;
                }
                ++idx;
                count = 0;
            }
        }
        return false;
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class Baekjoon11039 {
    public static void main(String[] args) {
        new Problem();
    }
}
