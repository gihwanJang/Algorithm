import java.io.*;
import java.util.*;

class Problem {
    int h;
    int n, q;
    int sum;
    PriorityQueue<Integer> pq;
    StringBuilder sb;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        sum = 0;
        sb = new StringBuilder();
        pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        h = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
            sum += num;

            while (sum - pq.peek() >= h) {
                sum -= pq.poll();
            }
        }

        solve();
        for (int i = 0; i < q; ++i) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
            sum += num;

            while (sum - pq.peek() >= h) {
                sum -= pq.poll();
            }
            solve();
        }
    }

    private void solve() {
        if (sum >= h) {
            sb.append(pq.size()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class C {
    public static void main(String[] args) {
        new Problem();
    }
}
