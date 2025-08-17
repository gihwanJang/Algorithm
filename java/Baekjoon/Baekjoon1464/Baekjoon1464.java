import java.io.*;
import java.util.*;

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private String s;

    public Problem() {
        try {
            input();
            solve();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }

    // private void solve() {
    //     String answer = s;
    //     List<Set<String>> memo = new ArrayList<>(s.length()+1);
    //     Queue<Map.Entry<String, Integer>> que = new ArrayDeque<>();

    //     for (int i = 0; i <= s.length(); ++i) {
    //         memo.add(new HashSet<>());
    //     }

    //     que.add(new AbstractMap.SimpleEntry<>(s, 0));
    //     while (!que.isEmpty()) {
    //         Map.Entry<String, Integer> curr = que.poll();

    //         if (answer.compareTo(curr.getKey()) > 0) {
    //             answer = curr.getKey();
    //         }
    //         if (curr.getValue() == s.length()) {
    //             continue;
    //         }

    //         StringBuilder rev = new StringBuilder();
    //         for (int i = curr.getValue(); i >= 0; --i) {
    //             rev.append(curr.getKey().charAt(i));
    //         }
    //         for (int i = curr.getValue()+1; i < s.length(); ++i) {
    //             rev.append(curr.getKey().charAt(i));
    //         }
    //         if (!memo.get(curr.getValue()+1).contains(rev.toString())) {
    //             memo.get(curr.getValue()+1).add(rev.toString());
    //             que.add(new AbstractMap.SimpleEntry<>(rev.toString(), curr.getValue() + 1));
    //         }

    //         if (!memo.get(curr.getValue()+1).contains(curr.getKey())) {
    //             memo.get(curr.getValue()+1).add(curr.getKey());
    //             que.add(new AbstractMap.SimpleEntry<>(curr.getKey(), curr.getValue() + 1));
    //         }
    //     }

    //     ANSWER.append(answer);
    // }

    private void solve() {
        Deque<Character> dq = new ArrayDeque<>();
        dq.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= dq.peekFirst()) {
                dq.addFirst(c);
            } else {
                dq.addLast(c);
            }
        }

        while (!dq.isEmpty()) ANSWER.append(dq.pollFirst());
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon1464 {
    public static void main(String[] args) {
        new Problem();
    }
}