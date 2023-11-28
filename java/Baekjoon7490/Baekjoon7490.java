import java.io.*;
import java.util.*;

class Problem {
    int n;
    StringBuilder ret;

    public Problem(int n) {
        this.n = n;
        ret = new StringBuilder();
    }

    public String solve() {
        StringBuilder sb = new StringBuilder("1");
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        makeZero(sb, stack, 2);
        return ret.toString();
    }

    private void makeZero(StringBuilder sb, Stack<Integer> stack, int start) {
        if(start == n+1) {
            int curr = 0;
            for(int i : stack) curr += i;
            if(curr == 0) {
                ret.append(sb.toString()).append("\n");
            }
            return;
        }

        int next;

        sb.append(' ').append(start);
        next = stack.pop();
        next = (Math.abs(next) * 10 + start) * (next / Math.abs(next));
        stack.add(next);
        makeZero(sb, stack, start+1);
        next = stack.pop();
        next /= 10;
        stack.add(next);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        sb.append('+').append(start);
        stack.add(start);
        makeZero(sb, stack, start+1);
        stack.pop();
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        sb.append('-').append(start);
        stack.add(-start);
        makeZero(sb, stack, start+1);
        stack.pop();
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
    }
}

public class Baekjoon7490 {
    public static void main(String[] args) throws Exception {
        Problem problem;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            problem = new Problem(Integer.parseInt(br.readLine()));
            System.out.println(problem.solve());
        }
    }
}
