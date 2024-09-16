import java.io.*;
import java.util.*;

class Problem {
    private int total;
    private int n, t;
    private int[][] p;
    // private int[][] memo;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        p = new int[n][];
        // memo = new int[t+1][n];
        for (int i = 0; i < n; ++i) {
            p[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            total += p[i][1];
        }
        // System.out.println(total - solve(t, 0));
        // System.out.println(total - solve());
        System.out.println(total - solve2());
    }

    // private int solve(int time, int idx) {
    //     if (idx == n) {
    //         return 0;
    //     } else if (memo[time][idx] != 0) {
    //         return memo[time][idx];
    //     }

    //     if (time - p[idx][0] >= 0) {
    //         memo[time][idx] = p[idx][1] + solve(time - p[idx][0], idx + 1);
    //     }
    //     memo[time][idx] = Math.max(memo[time][idx], solve(time, idx + 1));
    //     return memo[time][idx];
    // }

    // private int solve() {
    //     int res = 0;
    //     int[][] dp = new int[t+1][n];
    //     for (int i = 0; i <= t; ++i) {
    //         Arrays.fill(dp[i], -1);
    //     }
    //     dp[0][0] = 0;
    //     if (p[0][0] <= t) {
    //         dp[p[0][0]][0] = p[0][1];
    //     }
    //     for (int i = 0; i <= t; ++i) {
    //         for (int j = 0; j < n-1; ++j) {
    //             if (dp[i][j] != -1) {
    //                 dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);
    //                 if (i + p[j + 1][0] <= t) {
    //                     dp[i + p[j + 1][0]][j + 1] = Math.max(dp[i + p[j + 1][0]][j + 1], dp[i][j] + p[j + 1][1]);
    //                 }
    //             }
    //         }
    //     }
    //     for (int i = 0; i <= t; ++i) {
    //         res = Math.max(res, dp[i][n-1]);
    //     }
    //     return res;
    // }

    private int solve2() {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        for (int i = 0; i < n; ++i) {
            List<int[]> insertList = new ArrayList<>(map.size());
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getKey() + p[i][0] <= t) {
                    insertList.add(new int[]{e.getKey() + p[i][0], e.getValue() + p[i][1]});
                    ans = Math.max(ans, e.getValue() + p[i][1]);
                }
            }
            for (int[] e : insertList) {
                if (map.containsKey(e[0])) {
                    if (map.get(e[0]) < e[1]) {
                        map.put(e[0], e[1]);
                    }
                } else {
                    map.put(e[0], e[1]);
                }
            }
        }
        return ans;
    }
}

public class Baekjoon29704 {
    public static void main(String[] args) {
        new Problem();
    }
}
