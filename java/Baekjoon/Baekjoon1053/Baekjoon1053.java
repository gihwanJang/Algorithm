import java.io.*;
import java.util.*;

class MemoEntry {
    String string;
    boolean isUsed;

    public MemoEntry(String string, boolean isUsed) {
        this.string = string;
        this.isUsed = isUsed;
    }

    @Override
    public boolean equals(Object obj) {
        MemoEntry me = (MemoEntry)obj;
        return string.equals(me.string) && isUsed == me.isUsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, isUsed);
    }
}

class Problem {
    private int MAX = 987654321;
    private String string;
    private HashMap<MemoEntry,Integer> memo;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = br.readLine();
        memo = new HashMap<>();
    }

    private void output() {
        System.out.println(solve(string, false));
    }

    private int solve(String s, boolean isUsed) {
        if (isPalindrome(s)) {
            return 0;
        } else if (s.length() >= string.length() * 2) {
            return MAX;
        }
        MemoEntry entry = new MemoEntry(s, isUsed);
        if (memo.containsKey(entry)) {
            return memo.get(entry);
        }

        int count = MAX;
        StringBuilder sb = new StringBuilder(s);
        for (int c = 0; c < 26; ++c) {
            for (int i = 0; i <= sb.length(); ++i) {
                sb.insert(i, (char)('a' + c));
                count = Math.min(count, solve(sb.toString(), false) + 1);
                sb.deleteCharAt(i);
            }
            for (int i = 0; i < sb.length(); ++i) {
                char prev = sb.charAt(i);
                sb.setCharAt(i, (char)('a' + c));
                count = Math.min(count, solve(sb.toString(), false) + 1);
                sb.setCharAt(i, prev);
            }
        }
        for (int i = 0; i <= sb.length(); ++i) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            count = Math.min(count, solve(sb.toString(), false) + 1);
            sb.insert(i, c);
        }
        if (!isUsed) {
            for (int i = 0; i < sb.length(); ++i) {
                for (int j = i + 1; j < sb.length(); ++j) {
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(j));
                    sb.setCharAt(j, temp);
                    count = Math.min(count, solve(sb.toString(), true) + 1);
                    sb.setCharAt(j, sb.charAt(i));
                    sb.setCharAt(i, temp);
                }
            }
        }
        memo.put(entry, count);
        return count;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}

public class Baekjoon1053 {
    public static void main(String[] args) {
        new Problem();
    }
}
