import java.io.*;
import java.util.*;

class SegmentTree {
    private int size;
    private long[] tree;
    private long[] origin;

    public SegmentTree(long[] origin) {
        this.size = origin.length-1;
        this.tree = new long[4 * size];
        this.origin = origin;
        buildTree(1, size, 1);
    }

    public void update(int target, int value) {
        update(1, size, 1, target, value - origin[target]);
        origin[target] = value;
    }

    public long getSum(int start, int end) {
        return getSum(start, end, 1, size, 1);
    }

    private void update(int start, int end, int node, int target, long diff) {
        if (start > target || target > end) {
            return;
        }
        tree[node] += diff;
        if (start == end ) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, target, diff);
        update(mid + 1, end, node * 2 + 1, target, diff);
    }

    private long getSum(int start, int end, int low, int hight, int node) {
        if (hight < start || end < low) {
            return 0;
        } else if (low >= start && hight <= end) {
            return tree[node];
        }
        int mid = (low + hight) / 2;
        long left = getSum(start, end, low, mid, node * 2);
        long right = getSum(start, end, mid + 1, hight, node * 2 + 1);
        return (left + right);
    }

    private long buildTree(int start, int end, int node) {
        if (start == end) {
            return tree[node] = origin[start];
        }
        int mid = (start + end) / 2;
        long left = buildTree(start, mid, node * 2);
        long right = buildTree(mid + 1, end, node * 2 + 1);
        return (tree[node] = left + right);
    }
}

class Problem {
    private int[][] queries;
    private SegmentTree segmentTree;

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
        long[] arr = new long[Integer.parseInt(st.nextToken()) + 1];

        queries = new int[Integer.parseInt(st.nextToken())][4];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; ++i) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        segmentTree = new SegmentTree(arr);
        for (int i = 0; i < queries.length; ++i) {
            queries[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();

        for (int[] query : queries) {
            sb.append(segmentTree.getSum(Math.min(query[0], query[1]), Math.max(query[0], query[1])))
                    .append("\n");
            segmentTree.update(query[2], query[3]);
        }
        System.out.print(sb.toString());
    }
}

public class Baekjoon1275 {
    public static void main(String[] args) {
        new Problem();
    }
}