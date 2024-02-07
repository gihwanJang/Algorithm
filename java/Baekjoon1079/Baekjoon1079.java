import java.io.*;
import java.util.*;

class Problem {
    int n;
    int my;
    int[] score;
    int[][] graph;
    boolean[] visited;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int DFS(int depth, int death) {
        if (death == n - 1) {
            return depth;
        } else if ((n - death) % 2 == 1) {
            return morning(depth, death);
        }
        return night(depth, death);
    }

    private int morning(int depth, int death) {
        int ret = 0;
        int killed = -1;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (killed == -1) {
                    killed = i;
                } else if (score[killed] < score[i]) {
                    killed = i;
                }
            }
        }

        if (killed == my) {
            return depth;
        }
        visited[killed] = true;
        ret = Math.max(ret, DFS(depth, death + 1));
        visited[killed] = false;
        return ret;
    }

    private int night(int depth, int death) {
        int ret = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i] && i != my) {
                update(1, i);
                visited[i] = true;

                ret = Math.max(ret, DFS(depth + 1, death + 1));

                update(-1, i);
                visited[i] = false;
            }
        }
        return ret;
    }

    private void update(int flag, int idx) {
        for (int i = 0; i < n; ++i) {
            score[i] += flag * graph[idx][i];
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // total
        this.n = Integer.parseInt(br.readLine());
        // score
        this.score = Arrays.stream(br.readLine().split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();
        // graph
        this.graph = new int[n][n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }   
        // my
        this.my = Integer.parseInt(br.readLine());
        // visited
        this.visited = new boolean[n];
    }

    private void output() {
        System.out.println(DFS(0, 0));
    }
}

public class Baekjoon1079 {
    public static void main(String[] args) {
        new Problem();
    }
}
