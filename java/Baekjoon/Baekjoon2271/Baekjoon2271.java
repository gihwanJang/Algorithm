import java.io.*;
import java.util.*;

class SegmentTree {
    private int size;
    private int[][] tree;
    private int[] origin;

    public SegmentTree(int[] origin) {
        this.size = origin.length-1;
        this.tree = new int[4 * size][2];
        this.origin = origin;
        buildTree(1, size, 1);
    }
    
    public int getMax(int start, int end) {
        return getMax(start, end, 1, size, 1);
    }

    public int getMin(int start, int end) {
        return getMin(start, end, 1, size, 1);
    }

    private int getMax(int start, int end, int low, int hight, int node) {
        if (hight < start || end < low) {
			return 0;
		} else if (low >= start && hight <= end) {
			return tree[node][0];
		}
		
		int mid = (low + hight) / 2;
		int left = getMax(start, end, low, mid, node * 2);
		int right = getMax(start, end, mid + 1, hight, node * 2 + 1);
		return Math.max(left, right);
    }

    private int getMin(int start, int end, int low, int hight, int node) {
        if (hight < start || end < low) {
			return 0;
		} else if (low >= start && hight <= end) {
			return tree[node][1];
		}
		
		int mid = (low + hight) / 2;
		int left = getMin(start, end, low, mid, node * 2);
		int right = getMin(start, end, mid + 1, hight, node * 2 + 1);
		return Math.min(left, right);
    }

    private int[] buildTree(int start, int end, int node) {
        if (start == end) {
            tree[node][0] = origin[start];
            tree[node][1] = origin[start];
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = buildTree(start, mid, node * 2);
        int[] right = buildTree(mid + 1, end, node * 2 + 1);
        tree[node][0] = Math.max(left[0], right[0]);
        tree[node][1] = Math.min(left[1], right[1]);
        return tree[node];
    }
}

class Problem {
    private static final String YES = "Yes";
    private static final String NO = "No";

    private int n;
    private int[] arr;
    private SegmentTree st;
    private StringBuilder sb;

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
        sb = new StringBuilder();
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            n = Integer.parseInt(br.readLine().trim());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(isEdgeCase()).append("\n");
        }
    }

    private String isEdgeCase() {
        st = new SegmentTree(arr);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((arr[i] < arr[j]) && (st.getMax(i, j-1) != arr[i]) && (st.getMax(j, n) != arr[j])) {
                    return YES;
                } else if ((st.getMin(0, i) != arr[i]) && arr[i] < arr[j] && (st.getMin(i+1, j) != arr[j])) {
                    return YES;
                }
            }
        }
        return NO;
    }

    private void output() {
        System.out.print(sb.toString());
    }
}

public class Baekjoon2271 {
    public static void main(String[] args) {
        new Problem();
    }
}
