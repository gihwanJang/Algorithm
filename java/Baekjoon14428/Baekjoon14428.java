import java.io.*;
import java.util.*;

class SegmentTree {
    int size;
    int[] tree, nums;

    public SegmentTree(int[] nums, int n) {
        int h = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
        this.tree = new int[(int)Math.pow(2, h)];
        this.nums = nums;
        makeTree(0, 0, n-1);
        tree[tree.length-1] = Integer.MAX_VALUE;
    }

    public int update(int start, int end, int node, int idx) {
        if(start > idx || idx > end) {
            return nums.length-1;
        } else if(start == end) {
            if(node % 2 == 1) {
                return compare(idx, tree[node+1]);
            } else if(node != 0) {
                return compare(idx, tree[node-1]);
            } else {
                return idx;
            }
        }

        int mid = start + (end - start) / 2;
        int l = update(start, mid, 2*node+1, idx);
        int r = update(mid+1, end, 2*node+2, idx);
        tree[node] = compare(l, r);
        if(node % 2 == 1) {
            return compare(tree[node+1], tree[node]);
        } else if(node != 0){
            return compare(tree[node-1], tree[node]);
        } else {
            return tree[node];
        }
    }

    public int getSectionMin(int start, int end, int node, int l, int r) {
        if(r < start || l > end) {
            return nums.length-1;
        }
        if(l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        int left = getSectionMin(start, mid, 2*node+1, l, r);
        int right = getSectionMin(mid+1, end, 2*node+2, l, r);
        return compare(left, right);
    }

    private int makeTree(int node, int start, int end) {
        if(start == end) {
            return tree[node] = start;
        }
        int mid = start + (end - start) / 2;
        int l = makeTree(2 * node+1, start, mid);
        int r = makeTree(2 * node+2, mid + 1, end);
        return tree[node] = compare(l, r);
    }

    private int compare(int l, int r) {
        if(nums[l] < nums[r]) {
            return l;
        } else if(nums[r] < nums[l]) {
            return r;
        } else {
            return Math.min(l, r);
        }
    }
}

class Problem {
    int n;
    int[] nums;
    SegmentTree st;

    public Problem(int n) {
        this.n = n;
        nums = new int[n+1];
    }

    public void setTree() {
        nums[n] = Integer.MAX_VALUE;
        st = new SegmentTree(nums, n+1);
    }

    public void updateTree(int idx, int val) {
        nums[idx] = val;
        st.update(0, n, 0, idx);
    }

    public int getTreeSectionMin(int l, int r) {
        return st.getSectionMin(0, n, 0, l, r);
    }   
}

public class Baekjoon14428 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Integer.parseInt(st.nextToken());
        }
        problem.setTree();
        for(int i = Integer.parseInt(br.readLine()); i > 0; --i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            if(a == 1) {
                int c = Integer.parseInt(st.nextToken());
                problem.updateTree(b, c);
            } else {
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(problem.getTreeSectionMin(b, c)+1).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
