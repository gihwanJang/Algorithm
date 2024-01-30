import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class NumberInfo {

    int count;
    StringBuilder num;

    public NumberInfo(int count, StringBuilder num) {
        this.count = count;
        this.num = num;
    }

}

class Problem {

    int k;
    StringBuilder n;
    List<HashSet<String>> memo;

    public Problem(String n, int k) {
        this.k = k;
        this.n = new StringBuilder(n);
        this.memo = new ArrayList<>(k);
        IntStream.rangeClosed(0, k).forEach(i -> memo.add(new HashSet<>()));
    }

    public String solve() {
        NumberInfo curr;
        String maximum = "-1";
        Queue<NumberInfo> que = new ArrayDeque<>();

        que.add(new NumberInfo(0, n));
        while (!que.isEmpty()) {
            curr = que.poll();

            if (!memo.get(curr.count).contains(curr.num.toString())) {
                memo.get(curr.count).add(curr.num.toString());

                if (curr.count == k && curr.num.toString().compareTo(maximum) > 0) {
                    maximum = curr.num.toString();
                }

                if (curr.count < k) {
                    queingNext(que, curr);
                }
            }
        }
        return maximum;
    }

    private void queingNext(Queue<NumberInfo> que, NumberInfo curr) {
        for (int i = 0; i < n.length(); ++i) {
            char tmp = curr.num.charAt(i);

            for (int j = i + 1; j < n.length(); ++j) {
                if (!(i == 0 && curr.num.charAt(j) == '0')) {
                    StringBuilder next = new StringBuilder(curr.num);

                    next.setCharAt(i, next.charAt(j));
                    next.setCharAt(j, tmp);
                    que.add(new NumberInfo(curr.count + 1, next));
                }
            }
        }
    }

}

public class Baekjoon1039 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), Integer.parseInt(st.nextToken()));

        System.out.println(p.solve());
    }

}
