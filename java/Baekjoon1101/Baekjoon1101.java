import java.io.*;
import java.util.*;

class Problem {
    private int n, m;
    private int[][] box;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; ++i) {
            box[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private void output() {
        System.out.println(solve());
    }

    private int solve() {
        int answer = n - 1;
        boolean[] visited = new boolean[m];

        for (int joker = 0; joker < n; ++joker) {
            int count = 0;
            Arrays.fill(visited, false);

            for (int i = 0; i < n; ++i) {
                if (i != joker) {
                    int flag = 0;
                    int color = 0;

                    for (int j = 0; j < m; ++j) {
                        if (box[i][j] != 0) {
                            ++flag;
                            color = j;
                        }
                    }
                    if (flag == 1) {
                        if (visited[color]) {
                            ++count;
                        } else {
                            visited[color] = true;
                        }
                    } else if (flag > 1) {
                        ++count;
                    }
                }
            }
            answer = Math.min(answer, count);
        }
        return answer;
    }
}

public class Baekjoon1101 {
    public static void main(String[] args) {
        new Problem();
    }
}
