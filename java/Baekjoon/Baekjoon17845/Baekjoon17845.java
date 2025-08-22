import java.io.*;
import java.util.*;

class Study {
    int time;
    int value;

    public Study(int value, int time) {
        this.time = time;
        this.value = value;
    }
}

class Problem {
    int n, k;
    int[][] memo;
    Study[] studys;

    public Problem(int n, int k) {
        this.n = n;
        this.k = k;
        this.memo = new int[k + 1][n + 1];
        this.studys = new Study[k];
    }

    public int solve() {
        return DFS(0, n);
    }

    private int DFS(int idx, int time) {
        if (idx == k) {
            return 0;
        }

        if (memo[idx][time] != 0) {
            return memo[idx][time];
        }

        int exclude = DFS(idx + 1, time);

        if (studys[idx].time <= time) {
            return memo[idx][time] = Math.max(studys[idx].value + DFS(idx + 1, time - studys[idx].time), exclude);
        } else {
            return memo[idx][time] = exclude;
        }
    }
}

public class Baekjoon17845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < p.k; ++i) {
            st = new StringTokenizer(br.readLine());
            p.studys[i] = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(p.solve());
    }
}
