import java.io.*;
import java.util.*;

class SegmentTree {
    static int MOD = 1_000_000_007;
    int n;
    long[] tree;

    public SegmentTree(long[] num, int n) {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
		this.n = (int)Math.pow(2, h)-1;
        tree = new long[this.n];
        makeTree(num, 0, n-1, 0);
    }

    public long update(int start, int end, int node, int idx, long val) {
        if(idx < start || idx > end) {
            return 1;
        }
        if(start == end) {
            tree[node] = val;
            if(node%2 == 1) {
                return ((val%MOD) * (tree[node+1]%MOD)) % MOD;
            } else {
                return ((val%MOD) * (tree[node-1]%MOD)) % MOD;
            }
        }

        int mid = start + (end - start) / 2;
        long left = update(start, mid, 2*node+1, idx, val);
        long right = update(mid+1, end, 2*node+2, idx, val);
        long curr = tree[node] = ((left % MOD) * (right % MOD)) % MOD;
        if(node%2 == 1) {
            return ((curr%MOD) * (tree[node+1]%MOD)) % MOD;
        } else if(node != 0) {
            return ((curr%MOD) * (tree[node-1]%MOD)) % MOD;
        } else {
            return curr;
        }
    }

    public long getSection(int start, int end, int node, int l, int r) {
        if(r < start || l > end) {
            return 1;
        }
        if(l <= start && end <= r) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;
        long left = getSection(start, mid, 2*node+1, l, r);
        long right = getSection(mid+1, end, 2*node+2, l, r);
        return ((left % MOD) * (right % MOD)) % MOD;
    }

    private long makeTree(long[] nums, int start, int end, int idx) {
        if(start == end) {
            return tree[idx] = nums[start];
        } 
        
        int mid = start + (end - start )/ 2;
        long l = makeTree(nums, start, mid, 2*idx+1);
        long r = makeTree(nums, mid+1, end, 2*idx+2);
        tree[idx] = ((l % MOD) * (r % MOD)) % MOD;
        return tree[idx];
    }
}

class Problem {
    int n;
    long[] nums;
    SegmentTree st;

    public Problem(int n) {
        this.n = n;
        nums = new long[n];
    }

    public void setTree() {
        st = new SegmentTree(nums, n);
    }

    public void updateTree(int idx, long val) {
        st.update(0, n-1, 0, idx, val);
    }

    public long getTreeSection(int start, int end) {
        return st.getSection(0, n-1, 0, start, end);
    }
}

public class Baekjoon11505 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Problem problem = new Problem(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            problem.nums[i] = Long.parseLong(br.readLine());
        }
        problem.setTree();
        for(int i = 0; i < m+k; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
        
            if(a == 1) {
                long c = Long.parseLong(st.nextToken());
                problem.updateTree(b, c);
            } else {
                int c = Integer.parseInt(st.nextToken())-1;
                sb.append(problem.getTreeSection(b, c)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
