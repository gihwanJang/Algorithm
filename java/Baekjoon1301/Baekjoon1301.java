import java.io.*;
import java.util.*;

class Problem {
    int n, total;
    int[] arr;
    long[][][][][][][] memo;

    public Problem(int n) {
        this.n = n;
        total = 0;
        arr = new int[6];
        memo = new long[6][6][11][11][11][11][11];
        initializeArray();
    }

    public long solve() {
        return getCount(0, 0, 0);
    }

    private long getCount(int prev, int curr, long cnt) {
        if (cnt == total) {
            return 1;
        }
        
        long ret = memo[prev][curr][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]];

        if (memo[prev][curr][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]] != -1) {
            return memo[prev][curr][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]];
        }

        ret = 0;
        for (int i = 1; i <= n; ++i) {
            if (prev != i && curr != i && arr[i] > 0) {
                --arr[i];
                ret += getCount(curr, i, cnt+1);
                ++arr[i];
            }
    
        }
    
        return memo[prev][curr][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]] = ret;
    }

    private void initializeArray() {
        for (long[][][][][][] subarray6 : memo) {
            for (long[][][][][] subarray5 : subarray6) {
                for (long[][][][] subarray4 : subarray5) {
                    for (long[][][] subarray3 : subarray4) {
                        for (long[][] subarray2 : subarray3) {
                            for (long[] subarray1 : subarray2) {
                                Arrays.fill(subarray1, -1);
                            }
                        }
                    }
                }
            }
        }
    }
}

public class Baekjoon1301 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 1 ; i <= p.n; ++i) {
            p.arr[i] = Integer.parseInt(br.readLine());
            p.total += p.arr[i];
        }

        System.out.println(p.solve());
    }
}
