import java.io.*;
import java.util.*;
//화분
class Problem {
    int n, p, ans;
    int[] first, second;

    public Problem(int n, int p) {
        ans = 0;
        this.n = n;
        this.p = p;
        first = new int[n];
        second = new int[n];
    }

    public int solve() {
        giveFeed(1, true, first[0], 1);
        giveFeed(1, false, second[0], 1);
        return ans;
    }

    private void giveFeed(int depth, boolean prev, int hight, int idx) {
        if(depth == n) {
            ans = Math.max(ans, hight);
            return;
        }

        giveFeed(depth+1, true, hight + first[idx] - (prev ? p : 0), idx+1);
        giveFeed(depth+1, false, hight + second[idx] - (prev ? 0 : p), idx+1);
    }
}

public class B {
    public static void main(String[] args) throws Exception {
        Problem problem;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine());
            problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < problem.n; ++i)
                problem.first[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < problem.n; ++i)
                problem.second[i] = Integer.parseInt(st.nextToken());

            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
