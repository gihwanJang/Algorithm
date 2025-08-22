import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Problem {
    private class Element implements Comparable<Element> {
        int id;
        Queue<Integer> que;
    
        public Element(int id) {
            this.id = id;
            que = new ArrayDeque<>();
        }

        @Override
        public int compareTo(Element o) {
            if (que.isEmpty() || o.que.isEmpty() || o.que.peek() - que.peek() == 0) {
                return que.size() - o.que.size();
            }
            return (o.que.peek() - que.peek());
        }
    }
    private int n, k;
    private int[] seq;
    private Element[] priority;
    private boolean[] state;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        state = new boolean[k + 1];
        priority = new Element[k + 1];
        seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        IntStream.range(0, k + 1)
                .forEach(i -> priority[i] = new Element(i));
        IntStream.range(0, k)
                .forEach(i -> priority[seq[i]].que.add(i));
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int[] cnt = {0};
        List<Element> pq = new ArrayList<>();

        int start = init(pq);
        IntStream.range(start, k)
                .forEach(i -> {
                    pq.sort(null);
                    if (!state[seq[i]]) {
                        state[pq.get(0).id] = false;
                        state[seq[i]] = true;
                        priority[seq[i]].que.poll();
                        pq.set(0, priority[seq[i]]);
                        ++cnt[0];
                    } else {
                        priority[seq[i]].que.poll();
                    }
                });
        return cnt[0];
    }

    private int init(List<Element> pq) {
        int count = 0;
        for (int i = 0; i < k && count < n; ++i) {
            priority[seq[i]].que.poll();
            if (!state[seq[i]]) {
                pq.add(priority[seq[i]]);
                state[seq[i]] = true;
                ++count;
            }
        }
        return count;
    }
}

public class Baekjoon1700 {
    public static void main(String[] args) {
        new Problem();
    }
}