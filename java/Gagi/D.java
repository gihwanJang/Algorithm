import java.io.*;
import java.util.*;

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

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private void output() {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(1);
        for (int i = n; i > 2; i -= 2) {
            if (flag) {
                que.addLast(i);
                que.addFirst(i-1);
            } else {
                que.addFirst(i);
                que.addLast(i - 1);
            }
            flag = !flag;
        }
        if (n == 2) {
            que.add(2);
        } else if (n % 2 == 0) {
            que.addFirst(2);
        }
        while (!que.isEmpty()) {
            sb.append(que.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
}

public class D {
    public static void main(String[] args) {
        new Problem();
    }
}
