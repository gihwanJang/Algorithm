import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;
//야구선수
class Problem {
    int n, k;
    int[] players;

    public Problem(int n, int k) {
        this.n = n;
        this.k = k;
        players = new int[n];
    }

    public int solve() {
        int ans = 0;
        
        Arrays.sort(players);
        for(int i = 0, cnt; i < n; ++i) {
            cnt = 1;
            for(int j = i+1; j < n; ++j) {
                if(players[j] - players[i] <= k) ++cnt;
                else break;
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}

public class A {
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
            for(int i = 0; i < problem.n; ++i) {
                problem.players[i] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(t+1).append(" ").append(problem.solve()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
