import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    long val;
    int idx;

    public Pair(int idx, long val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.val > val) {
            return 1;
        } else if (o.val < val) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[{idx : " + idx + "}, " + "{val : " + val + "}],\n";
    }
}

class Problem {
    private static final long MOD = 1000000007;
    private int n;
    private long[] nums;

    public Problem() {
        try {
            input();
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    private void solve() {
        long total = 0;
        List<Pair> pairList = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; ++i) {
            pq.add(new Pair(i, nums[i]));
        }

        while (hasNextPair(pairList, pq)) {
            long sum = 1;
            for (int i = 1; i < pairList.size(); ++i) {
                long count = 1;
                for (int j = 1; j < i; ++j) {
                    count = multiMod(count, pairList.get(j - 1).idx - pairList.get(j).idx);
                }
                sum = sumMod(sum, count);
            }
            total = sumMod(total, sum);
            System.out.println(String.format("count : %d, tatal : %d", pairList.size(), total));
        }
        System.out.println(total);
    }

    private boolean hasNextPair(List<Pair> pairList, PriorityQueue<Pair> pq) {
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (pairList.isEmpty() || pairList.getLast().idx > p.idx) {
                pairList.add(p);
                return true;
            }
        }
        return false;
    }

    private long sumMod(long a, long b) {
        return (a + b) % MOD;
    }

    private long multiMod(long a, long b) {
        return (a * b) % MOD;
    }
}

public class Baekjoon22880 {
    public static void main(String[] args) {
        new Problem();
    }
}
