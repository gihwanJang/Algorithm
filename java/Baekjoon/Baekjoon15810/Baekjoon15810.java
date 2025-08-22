import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private long target;
    private int[] times;

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
        target = Long.parseLong(st.nextToken());
        times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private void output() {
        System.out.println(binarySearch());
    }

    private long binarySearch() {
        long start = 0L;
        long end = 1000000000000L;

        while (start < end) {
            long mid = (start + end) / 2;
            if (getCount(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private long getCount(long time) {
        long count = 0;
        for (int i = 0; i < n; ++i) {
            count += time / times[i];
        }
        return count;
    }
}

public class Baekjoon15810 {
    public static void main(String[] args) {
        new Problem();
    }
}
