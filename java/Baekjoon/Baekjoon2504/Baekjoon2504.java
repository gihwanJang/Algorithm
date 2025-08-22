import java.io.*;
import java.util.*;

class Problem {
    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solve(br.readLine());
    }

    private void solve(String s) {
        int res = 0;
        int value = 1;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                value *= 2;
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                value *= 3;
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                } else if (s.charAt(i - 1) == '(') {
                    res += value;
                }
                stack.pop();
                value /= 2;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                } else if (s.charAt(i - 1) == '[') {
                    res += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }
}

public class Baekjoon2504 {
    public static void main(String[] args) {
        new Problem();
    }
}
