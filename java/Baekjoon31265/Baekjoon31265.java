import java.io.*;
import java.util.*;

class Problem {
    int n, m;
    List<int[][]> memo;
    List<int[]> trinings;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        this.n = Integer.parseInt(st.nextToken());
        this.m = Integer.parseInt(st.nextToken());
        this.trinings = new ArrayList<>(n);
        this.memo = new ArrayList<>(n);
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .forEach(i -> {
                    trinings.add(new int[i]);
                    memo.add(new int[i][m + 1]);
                });
        for (int i = 0; i < n; ++i) {
            trinings.set(i, Arrays.stream(br.readLine().split(" "))
                .mapToInt(j -> Integer.parseInt(j))
                .toArray()
            );
        }
    }

    private void output() {
        System.out.println(solve(0, 0, 0));
    }

    private int solve(int r, int c, int time) {
        if (r == n) {
            return time;
        } else if (memo.get(r)[c][time] != 0) {
            return memo.get(r)[c][time];
        }

        memo.get(r)[c][time] = -1;
        // 포함하고 아래로 내려가는 경우
        if (trinings.get(r)[c] + time <= m) {
            memo.get(r)[c][time] = Math.max(memo.get(r)[c][time], solve(r + 1, 0, trinings.get(r)[c] + time));
        }
        if (c + 1 < trinings.get(r).length) {
            // 포함하지 않고 옆에 것을 고르는 경우
            memo.get(r)[c][time] = Math.max(memo.get(r)[c][time], solve(r, c + 1, time));
            // 포함하고 옆에 것을 고르는 경우
            if (trinings.get(r)[c] + time <= m) {
                memo.get(r)[c][time] = Math.max(memo.get(r)[c][time], solve(r, c + 1, trinings.get(r)[c] + time));
            }
        }
        return memo.get(r)[c][time];
    }
}

public class Baekjoon31265 {
    public static void main(String[] args) {
        new Problem();
    }
}