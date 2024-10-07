import java.io.*;
import java.util.*;

class Problem {
    private String text;
    private String pattern;
    private int[] table;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        pattern = br.readLine();
        solve();
    }

    private void solve() {
        makeTabke();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[]{0};
        List<Integer> loc = new ArrayList<>();
        find(count, loc);
        sb.append(count[0]).append("\n");
        for (int i : loc) {
            sb.append(i + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    private void makeTabke() {
        table = new int[pattern.length()];
        int s = 0;
        for (int e = 1; e < pattern.length(); ++e) {
            while (s > 0 && pattern.charAt(e) != pattern.charAt(s)) {
                s = table[s - 1];
            }
            if (pattern.charAt(s) == pattern.charAt(e)) {
                table[e] = ++s;
            }
        }
    }

    private void find(int[] count, List<Integer> loc) {
        int j = 0;
        for (int i = 0; i < text.length(); ++i) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    ++count[0];
                    loc.add(i - pattern.length() + 2);
                    j = table[j];
                } else {
                    ++j;
                }
            }
        }
    }
}

public class Baekjoon1786 {
    public static void main(String[] args) {
        new Problem();
    }
}
