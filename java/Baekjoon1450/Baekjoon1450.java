import java.io.*;
import java.util.*;

class Problem {
    int n, c;
    int[] weights;
    List<Long> lw, rw;
    public Problem(int n, int c) {
        this.n = n;
        this.c = c;
        this.weights = new int[n];
        this.lw = new ArrayList<>(n);
        this.rw = new ArrayList<>(n);
    }
    public int solve() {
        int cnt = 0;
        
        dfs(0, n/2, 0, lw);
        dfs(n/2, n, 0, rw);

        lw.sort(null);
        for (long e : rw) {
            if (e <= c) {
                cnt += upperBound(e);
            }
        }
        return cnt;
    }
    private int upperBound(long e) {
        int left = 0;
        int right = lw.size();
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if(e + lw.get(mid) > c)
                right = mid;
            else
                left = mid+1;
        }
        return right;
    }
    private void dfs(int s, int e, long sum, List<Long> w) {
        if (s >= e) {
            w.add(sum);
            return;
        }
        dfs(s + 1, e, sum, w);
        dfs(s + 1, e, sum + weights[s], w);
    }
}

public class Baekjoon1450 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p.n; ++i) {
            p.weights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(p.solve());
    }
}
