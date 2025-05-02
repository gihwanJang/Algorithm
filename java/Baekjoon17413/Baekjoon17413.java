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
        boolean isStack = true;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
                isStack = false;
            } else if (s.charAt(i) == '>') {
                sb.append(s.charAt(i));
                isStack = true;
            } else if (s.charAt(i) == ' ' && isStack) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                if (isStack) {
                    stack.push(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}

public class Baekjoon17413 {
    public static void main(String[] args) {
        new Problem();
    }
}
