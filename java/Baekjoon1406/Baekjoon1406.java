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
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        char[][] op = new char[n][];
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            if (line.charAt(0) == 'P') {
                op[i] = new char[]{line.charAt(0), line.charAt(2)};
            } else {
                op[i] = new char[]{line.charAt(0)};
            }
        }
        solve(s, n, op);
    }

    private void solve(String s, int n, char[][] op) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Character> rightStack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (op[i][0] == 'L' && sb.length() != 0) {
                rightStack.push(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            } else if (op[i][0] == 'D' && !rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            } else if (op[i][0] == 'B' && sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else if (op[i][0] == 'P') {
                sb.append(op[i][1]);
            }
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
    }
}

public class Baekjoon1406 {
    public static void main(String[] args) {
        new Problem();
    }
}
